

var Customer = React.createClass({
	
	getInitialState: function() {
	    return {display: true };
	  },
	  handleDelete() {
	    var self = this;
	    $.ajax({
	      url: self.props.customer._links.self.href,
	      type: 'DELETE',
	      success: function(result) {
	        self.setState({display: false});
	        
	      },
	      error: function(xhr, ajaxOptions, thrownError) {
	        toastr.error(xhr.responseJSON.message);
	      }
	    });
	  },
		
	render: function() {
    return (
      <tr>
        <td>{this.props.customer.name}</td>
        <td>{this.props.customer.city}</td>
        <td>{this.props.customer.state}</td>
        <td>
        <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
        </td>
      </tr>);
  }
});
var CustomerTable = React.createClass({
  render: function() {
    var rows = [];
    this.props.customers.forEach(function(customer) {
      rows.push(<Customer customer={customer} />);
    });
    return (
    	<div className="container">
	     <table className="table table-striped">
	        <thead>
	          <tr>
	            <th>Name</th><th>city</th><th>state</th>
	          </tr>
	        </thead>
	        <tbody>{rows}</tbody>
	      </table>
	      </div>
	      );
  }
});

var EMPLOYEES = [
  {name: 'Joe Biden', age: 45, years: 5},
  {name: 'President Obama', age: 54, years: 8},
  {name: 'Crystal Mac', age: 34, years: 12},
  {name: 'James Henry', age: 33, years: 2}
]; 
var App = React.createClass({

	  loadCustomersFromServer: function () {
	    var self = this;
	    
	    $.ajax({
	      url: "http://localhost:8080/api/customers"
	    }).then(function (data) {
	      self.setState({customers: data._embedded.customers});
	    });
	  },

	  getInitialState: function () {
	    return {customers: []};
	  },

	  componentDidMount: function () {
	    this.loadCustomersFromServer();
	  },

	  render() {
	    return ( <CustomerTable customers={this.state.customers}/> );
	  }
	});

ReactDOM.render(
		  <App  />, document.getElementById('root')
		);
		