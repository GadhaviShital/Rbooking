package edu.unh.rbooking.restaurant;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericDao;
import edu.unh.rbooking.common.GenericServiceImpl;
import edu.unh.rbooking.exception.ServiceException;

public class RestaurantServiceImpl extends GenericServiceImpl<RestaurantBO, RestaurantDO, Integer>implements RestaurantService {

	
	private RestaurantDAO resturantDAO;
	
	public RestaurantServiceImpl(RestaurantDAO ResturantDAO, DTO<RestaurantBO, RestaurantDO> dto) {
		super(ResturantDAO, dto);
		// TODO Auto-generated constructor stub
		
		// validate address and phone number check for empty or null
		
	}

	@Override
	public RestaurantBO save(RestaurantBO restaurantBO) throws ServiceException {
		// TODO Auto-generated method stub
		if(restaurantBO.getName() == null)
		{
			throw new ServiceException("Restaurant name cannot be null or empty");
		}
		
		if(restaurantBO.getPhoneNumber() == null)
		{
			throw new ServiceException("Restaurant phone number cannot be null or empty");
		}
		
		if(restaurantBO.getAddress() == null)
		{
			throw new ServiceException("Restaurant address cannot be null or empty");
		}
		
		return super.saveOrUpdate(restaurantBO);
	}


}
