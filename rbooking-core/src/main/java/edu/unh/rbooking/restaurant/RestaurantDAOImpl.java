package edu.unh.rbooking.restaurant;

import edu.unh.rbooking.common.GenericDaoHibernate;

public class RestaurantDAOImpl extends GenericDaoHibernate<RestaurantDO, Integer> implements RestaurantDAO{

	public RestaurantDAOImpl() {
		super(RestaurantDO.class);
	}
	

}
