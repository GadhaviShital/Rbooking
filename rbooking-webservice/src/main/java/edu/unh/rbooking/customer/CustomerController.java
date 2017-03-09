package edu.unh.rbooking.customer;

import javax.ws.rs.Path;

import edu.unh.rbooking.common.GenericControllerImpl;

@Path("/customer")
public class CustomerController extends GenericControllerImpl<CustomerBO, CustomerDO, Integer>{
	public CustomerController(CustomerService customerService) {
		super(customerService);		
	}
}
