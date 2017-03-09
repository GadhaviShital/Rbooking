package edu.unh.rbooking.menu;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;

public class MenuServiceImpl extends GenericServiceImpl<MenuBO, MenuDO, Integer>implements MenuService {

	private MenuDAO menuDAO;
	
	public MenuServiceImpl(MenuDAO menuDAO, DTO<MenuBO, MenuDO> dto) {
		super(menuDAO, dto);
		this.menuDAO = menuDAO;
	}
	
	
}
