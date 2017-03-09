package edu.unh.rbooking.employee;

import java.util.List;

import edu.unh.rbooking.common.GenericService;
import edu.unh.rbooking.exception.RBookingException;

public interface EmployeeService extends GenericService<EmployeeBO, EmployeeDO, Integer>{
	public List<EmployeeBO> getAllServer() throws RBookingException;
}
