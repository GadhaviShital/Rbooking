package edu.unh.rbooking.employee;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;
import edu.unh.rbooking.exception.RBookingException;

public class EmployeeServiceImpl extends GenericServiceImpl<EmployeeBO, EmployeeDO, Integer>implements EmployeeService {

	private EmployeeDAO employeeDAO;
	private DTO<EmployeeBO, EmployeeDO> dto;
	
	public EmployeeServiceImpl(EmployeeDAO userDAO, DTO<EmployeeBO, EmployeeDO> dto) {
		super(userDAO, dto);
		this.employeeDAO = userDAO;
		this.dto = dto;
	}
	
	@Transactional(value="coreTransactionManager")
	public List<EmployeeBO> getAllServer() throws RBookingException
	{
		List<EmployeeDO> employeeDOs = employeeDAO.getAllServer();
		return dto.convertDOToBO(employeeDOs, EmployeeBO.class);
	}
	
}
