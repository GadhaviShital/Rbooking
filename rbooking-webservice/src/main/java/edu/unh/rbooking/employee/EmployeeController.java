package edu.unh.rbooking.employee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import edu.unh.rbooking.common.GenericControllerImpl;
import edu.unh.rbooking.credential.CredentialBO;
import edu.unh.rbooking.credential.CredentialService;
import edu.unh.rbooking.exception.RBookingException;
import edu.unh.rbooking.exception.ServiceException;

@Path("/employee")
public class EmployeeController extends GenericControllerImpl<EmployeeBO, EmployeeDO, Integer>{

	private final CredentialService credentialService;
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService userService, CredentialService credentialService) {
		super(userService);		
		this.credentialService = credentialService;
		this.employeeService = userService;
	}	
	
	@POST
	@Path("/credential")
	public void setCredentials(CredentialBO credential) throws ServiceException
	{
		credentialService.saveOrUpdate(credential);
	}
	
	@Path("/server")
	@GET
	public List<EmployeeBO> getServer() throws RBookingException
	{
		return employeeService.getAllServer();
	}
}
