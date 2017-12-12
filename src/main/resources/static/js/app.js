'use strict';



// tag::vars[]

const React = require('react');

const ReactDOM = require('react-dom');

const client = require('./client');

// end::vars[]



// tag::app[]

class App extends React.Component {



	constructor(props) {

		super(props);

		this.state = {employees: []};

	}



	componentDidMount() {

		client({method: 'GET', path: '/api/customers'}).done(response => {

			this.setState({employees: response.entity._embedded.customers});

		});

	}



	render() {

		return (

			<EmployeeList employees={this.state.employees}/>

		)

	}

}

// end::app[]



// tag::employee-list[]

class EmployeeList extends React.Component{

	render() {

		var employees = this.props.employees.map(employee =>

			<Employee key={employee._links.self.href} employee={employee}/>

		);

		return (

			<table>

				<tbody>

					<tr>

						<th>First Name</th>

						<th>Last Name</th>

						<th>Description</th>

					</tr>

					{employees}

				</tbody>

			</table>

		)

	}

}

// end::employee-list[]



// tag::employee[]

class Employee extends React.Component{

	render() {

		return (

			<tr>

				<td>{this.props.employee.name}</td>

				<td>{this.props.employee.city}</td>

				<td>{this.props.employee.state}</td>

			</tr>

		)

	}

}

// end::employee[]



// tag::render[]

ReactDOM.render(

	<App />,

	document.getElementById('root')

)

// end::render[]