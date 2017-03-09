package edu.unh.rbooking.menu;

import javax.ws.rs.Path;
import edu.unh.rbooking.common.GenericControllerImpl;

@Path("/menu")
public class MenuController extends GenericControllerImpl<MenuBO, MenuDO, Integer>{
	public MenuController(MenuService menuService) {
		super(menuService);		
	}
}
