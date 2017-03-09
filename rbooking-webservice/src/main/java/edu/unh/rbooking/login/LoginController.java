package edu.unh.rbooking.login;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import edu.unh.rbooking.credential.CredentialBO;
import edu.unh.rbooking.credential.CredentialService;
import edu.unh.rbooking.employee.EmployeeBO;
import edu.unh.rbooking.exception.ServiceException;

@Path("/login")
public class LoginController{
	private CredentialService credentialService;
	public LoginController(CredentialService credentialService) {	
		this.credentialService = credentialService;
	}
	
	@POST
	public EmployeeBO login(CredentialBO credential) throws ServiceException
	{
		return credentialService.login(credential);
	}
}
