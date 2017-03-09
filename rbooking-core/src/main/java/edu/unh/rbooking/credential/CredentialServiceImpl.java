package edu.unh.rbooking.credential;

import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.common.DTO;
import edu.unh.rbooking.common.GenericServiceImpl;
import edu.unh.rbooking.employee.EmployeeBO;
import edu.unh.rbooking.exception.ServiceException;

public class CredentialServiceImpl extends GenericServiceImpl<CredentialBO, CredentialDO, Integer>implements CredentialService {

	private CredentialDAO credentialDAO;
	
	public CredentialServiceImpl(CredentialDAO credentialDAO, DTO<CredentialBO, CredentialDO> dto) {
		super(credentialDAO, dto);
		this.credentialDAO = credentialDAO;
	}
	@Override
	@Transactional(value="coreTransactionManager")
	public EmployeeBO login(CredentialBO credential) throws ServiceException {
		try
		{
			CredentialDO credentialDO = credentialDAO.login(credential.getUserName(), credential.getPassword());
			CredentialBO credentialBO = dto.convertDOToBO(credentialDO, CredentialBO.class);
			return credentialBO.getEmployee();
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}
	
	
}
