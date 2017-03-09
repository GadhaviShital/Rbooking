package edu.unh.rbooking.menu;

import java.util.List;

import edu.unh.rbooking.common.GenericDaoHibernate;
import edu.unh.rbooking.exception.DAOException;

public class MenuDAOImpl extends GenericDaoHibernate<MenuDO, Integer> implements MenuDAO {

	public MenuDAOImpl() {
		super(MenuDO.class);
	}
	@Override
	public MenuDO login(String userName, String password) throws DAOException{
		String QUERY = "SELECT * FROM UserDO WHERE userName="+userName+" AND password="+password;
		
		List<MenuDO> users = super.getByQuery(QUERY);
		
		return users.get(0);
	}
}
