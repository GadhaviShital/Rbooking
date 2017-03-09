package edu.unh.rbooking.employee;

import java.util.List;

import edu.unh.rbooking.common.GenericDao;
import edu.unh.rbooking.exception.RBookingException;

public interface EmployeeDAO extends GenericDao<EmployeeDO, Integer> {
	public List<EmployeeDO> getAllServer() throws RBookingException;
}
