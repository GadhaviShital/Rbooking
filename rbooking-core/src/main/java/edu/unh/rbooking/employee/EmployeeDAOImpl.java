package edu.unh.rbooking.employee;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.unh.rbooking.common.GenericDaoHibernate;
import edu.unh.rbooking.exception.RBookingException;

public class EmployeeDAOImpl extends GenericDaoHibernate<EmployeeDO, Integer> implements EmployeeDAO {

	public EmployeeDAOImpl() {
		super(EmployeeDO.class);
	}
	@Override
	public List<EmployeeDO> getAllServer() throws RBookingException {
		String QUERY = "FROM EmployeeDO where type = 'server'";
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(QUERY);
		return query.list();
	}
}
