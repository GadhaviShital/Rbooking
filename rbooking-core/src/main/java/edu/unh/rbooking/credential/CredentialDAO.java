package edu.unh.rbooking.credential;

import edu.unh.rbooking.common.GenericDao;
import edu.unh.rbooking.exception.DAOException;

public interface CredentialDAO extends GenericDao<CredentialDO, Integer> {
	public CredentialDO login(String userName, String password) throws DAOException;
}
