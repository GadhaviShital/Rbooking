package edu.unh.rbooking.customer;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;

public class CustomerServiceImpl extends GenericServiceImpl<CustomerBO, CustomerDO, Integer>implements CustomerService {

	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl(CustomerDAO customerDAO, DTO<CustomerBO, CustomerDO> dto) {
		super(customerDAO, dto);
		this.customerDAO = customerDAO;
	}
	
	
}
