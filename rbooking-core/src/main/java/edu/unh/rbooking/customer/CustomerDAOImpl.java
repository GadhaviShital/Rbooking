package edu.unh.rbooking.customer;

import edu.unh.rbooking.common.GenericDaoHibernate;

public class CustomerDAOImpl extends GenericDaoHibernate<CustomerDO, Integer> implements CustomerDAO {

	public CustomerDAOImpl() {
		super(CustomerDO.class);
	}
}
