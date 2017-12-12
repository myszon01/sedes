'use strict';



// tag::vars[]

const React = require('react');

const ReactDOM = require('react-dom');

const client = require('./client');

const follow = require('./follow'); // function to hop multiple links by "rel"

const root = '/api';
//end::vars[]

// tag::app[]

class App extends React.Component {



	constructor(props) {
		super(props);
		this.state = {customers: [], attributes: [], pageSize: 2, links: {}};
		this.updatePageSize = this.updatePageSize.bind(this);
		//this.onCreate = this.onCreate.bind(this);
		this.onDelete = this.onDelete.bind(this);
		this.onNavigate = this.onNavigate.bind(this);

	}


	// tag::follow-2[]
	loadFromServer(pageSize) {
		follow(client, root, [
			{rel: 'customers', params: {size: pageSize}}]
		).then(customerCollection => {
			return client({
				method: 'GET',
				path: customerCollection.entity._links.profile.href,
				headers: {'Accept': 'application/schema+json'}
			}).then(schema => {
				this.schema = schema.entity;
				return customerCollection;
			});
		}).done(customerCollection => {
			this.setState({
				customers: customerCollection.entity._embedded.customer,
				attributes: Object.keys(this.schema.properties),
				pageSize: pageSize,
				links: customerCollection.entity._links});
		});
	}
	
	// tag::create[]
	onCreate(newCustomer) {
		follow(client, root, ['customers']).then(customerCollection => {
			return client({
				method: 'POST',
				path: customerCollection.entity._links.self.href,
				entity: newCustomer,
				headers: {'Content-Type': 'application/json'}
			})
		}).then(response => {
			return follow(client, root, [
				{rel: 'customers', params: {'size': this.state.pageSize}}]);
		}).done(response => {
			if (typeof response.entity._links.last != "undefined") {
				this.onNavigate(response.entity._links.last.href);
			} else {
				this.onNavigate(response.entity._links.self.href);
			}
		});
	}
	// end::create[]

	// tag::delete[]
	onDelete(customer) {
		client({method: 'DELETE', path: customer._links.self.href}).done(response => {
			this.loadFromServer(this.state.pageSize);
		});
	}
	// end::delete[]

	// tag::navigate[]
	onNavigate(navUri) {
		client({method: 'GET', path: navUri}).done(customerCollection => {
			this.setState({
				customers: customerCollection.entity._embedded.customers,
				attributes: this.state.attributes,
				pageSize: this.state.pageSize,
				links: customerCollection.entity._links
			});
		});
	}
	// end::navigate[]
	
	// tag::update-page-size[]
	updatePageSize(pageSize) {
		if (pageSize !== this.state.pageSize) {
			this.loadFromServer(pageSize);
		}
	}
	// end::update-page-size[]

	// tag::follow-1[]
	componentDidMount() {
		this.loadFromServer(this.state.pageSize);
	}
	// end::follow-1[]

	render() {
		return (
			<div>
				<CreateDialog attributes={this.state.attributes} onCreate={this.onCreate}/>
				<CustomerList customers={this.state.customers}
							  links={this.state.links}
							  pageSize={this.state.pageSize}
							  onNavigate={this.onNavigate}
							  onDelete={this.onDelete}
							  updatePageSize={this.updatePageSize}/>
			</div>
		)
	}

}

// end::app[]

//tag::create-dialog[]
class CreateDialog extends React.Component {

	constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
		e.preventDefault();
		var newCustomer = {};
		this.props.attributes.forEach(attribute => {
			newCustomer[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
		});
		this.props.onCreate(newCustomer);

		// clear out the dialog's inputs
		this.props.attributes.forEach(attribute => {
			ReactDOM.findDOMNode(this.refs[attribute]).value = '';
		});

		// Navigate away from the dialog to hide it.
		window.location = "#";
	}

	render() {
		var inputs = this.props.attributes.map(attribute =>
			<p key={attribute}>
				<input type="text" placeholder={attribute} ref={attribute} className="field" />
			</p>
		);

		return (
			<div>
				<a href="#createCustomer">Create</a>

				<div id="createCustomer" className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>

						<h2>Create new customer</h2>

						<form>
							{inputs}
							<button onClick={this.handleSubmit}>Create</button>
						</form>
					</div>
				</div>
			</div>
		)
	}

}
// end::create-dialog[]

// tag::customer-list[]
class CustomerList extends React.Component {

	constructor(props) {
		super(props);
		this.handleNavFirst = this.handleNavFirst.bind(this);
		this.handleNavPrev = this.handleNavPrev.bind(this);
		this.handleNavNext = this.handleNavNext.bind(this);
		this.handleNavLast = this.handleNavLast.bind(this);
		this.handleInput = this.handleInput.bind(this);
	}

	// tag::handle-page-size-updates[]
	handleInput(e) {
		e.preventDefault();
		var pageSize = ReactDOM.findDOMNode(this.refs.pageSize).value;
		if (/^[0-9]+$/.test(pageSize)) {
			this.props.updatePageSize(pageSize);
		} else {
			ReactDOM.findDOMNode(this.refs.pageSize).value =
				pageSize.substring(0, pageSize.length - 1);
		}
	}
	// end::handle-page-size-updates[]

	// tag::handle-nav[]
	handleNavFirst(e){
		e.preventDefault();
		this.props.onNavigate(this.props.links.first.href);
	}

	handleNavPrev(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.prev.href);
	}

	handleNavNext(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.next.href);
	}

	handleNavLast(e) {
		e.preventDefault();
		this.props.onNavigate(this.props.links.last.href);
	}
	// end::handle-nav[]

	
	render() {
		var customers = this.props.customers.map(customer =>
			<Customer key={customer._links.self.href} customer={customer} onDelete={this.props.onDelete}/>
		);

		var navLinks = [];
		if ("first" in this.props.links) {
			navLinks.push(<button key="first" onClick={this.handleNavFirst}>&lt;&lt;</button>);
		}
		if ("prev" in this.props.links) {
			navLinks.push(<button key="prev" onClick={this.handleNavPrev}>&lt;</button>);
		}
		if ("next" in this.props.links) {
			navLinks.push(<button key="next" onClick={this.handleNavNext}>&gt;</button>);
		}
		if ("last" in this.props.links) {
			navLinks.push(<button key="last" onClick={this.handleNavLast}>&gt;&gt;</button>);
		}

		return (
			<div>
				<input ref="pageSize" defaultValue={this.props.pageSize} onInput={this.handleInput}/>
				<table>
					<tbody>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Description</th>
							<th></th>
						</tr>
						{customers}
					</tbody>
				</table>
				<div>
					{navLinks}
				</div>
			</div>
		)
	}
	
}

// tag::customer[]

// end::customer-list[]



// tag::customer[]

class Customer extends React.Component{
	
	constructor(props) {
		super(props);
		this.handleDelete = this.handleDelete.bind(this);
	}

	handleDelete() {
		this.props.onDelete(this.props.employee);
	}


	render() {

		return (

			<tr>

				<td>{this.props.customer.name}</td>

				<td>{this.props.customer.city}</td>

				<td>{this.props.customer.state}</td>
				
				<td>
					<button onClick={this.handleDelete}>Delete</button>
				</td>
			</tr>

		)

	}

}

// end::customer[]



// tag::render[]

ReactDOM.render(

	<App />,

	document.getElementById('root')

)

// end::render[]