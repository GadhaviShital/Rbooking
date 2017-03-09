package edu.unh.rbooking.credential;

import edu.unh.rbooking.common.GenericService;
import edu.unh.rbooking.employee.EmployeeBO;
import edu.unh.rbooking.exception.ServiceException;

public interface CredentialService extends GenericService<CredentialBO, CredentialDO, Integer>{
	public EmployeeBO login(CredentialBO credential) throws ServiceException;
}
