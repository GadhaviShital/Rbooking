package edu.unh.rbooking.restaurant;

import edu.unh.rbooking.common.GenericService;
import edu.unh.rbooking.exception.ServiceException;

public interface RestaurantService extends GenericService<RestaurantBO, RestaurantDO, Integer>{
	
	public RestaurantBO save(RestaurantBO restaurantBO) throws ServiceException;
		
}
