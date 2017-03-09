package edu.unh.rbooking.credential;

import java.util.List;

import org.hibernate.Query;

import edu.unh.rbooking.common.GenericDaoHibernate;
import edu.unh.rbooking.exception.DAOException;

public class CredentialDAOImpl extends GenericDaoHibernate<CredentialDO, Integer> implements CredentialDAO {

	public CredentialDAOImpl() {
		super(CredentialDO.class);
	}
	@Override
	public CredentialDO login(String userName, String password) throws DAOException {
		String QUERY = "FROM CredentialDO WHERE userName = :userName AND password = :password";
		Query query = sessionFactory.getCurrentSession().createQuery(QUERY);
		
		query.setString("userName", userName);
		query.setString("password", password);
		
		List<CredentialDO> list = query.list();
		
		if(list == null || list.size() == 0)
		{
			throw new DAOException("Invalid credential");
		}
		
		return list.get(0);
	}
}
