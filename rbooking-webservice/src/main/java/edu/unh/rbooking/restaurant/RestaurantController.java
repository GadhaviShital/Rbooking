package edu.unh.rbooking.restaurant;

import javax.ws.rs.Path;
import edu.unh.rbooking.common.GenericControllerImpl;

@Path("/restaurant")
public class RestaurantController extends GenericControllerImpl<RestaurantBO, RestaurantDO, Integer>{
	public RestaurantController(RestaurantService restaurantService) {
		super(restaurantService);		
	}
}
