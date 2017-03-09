package edu.unh.rbooking.menu;

import edu.unh.rbooking.common.GenericDao;
import edu.unh.rbooking.exception.DAOException;

public interface MenuDAO extends GenericDao<MenuDO, Integer> {
	public MenuDO login(String userName, String password) throws DAOException;
}
