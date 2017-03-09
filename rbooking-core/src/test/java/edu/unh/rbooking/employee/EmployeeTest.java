package edu.unh.rbooking.employee;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensaml.xml.security.credential.Credential;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.credential.CredentialService;
import edu.unh.rbooking.employee.EmployeeBO;
import edu.unh.rbooking.employee.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/rbooking-core-context.xml")
@TransactionConfiguration( transactionManager="coreTransactionManager", defaultRollback = true)
@Transactional(value="coreTransactionManager")
public class EmployeeTest {
	
	@Resource(name="employeeService")
	EmployeeService employeeService;
	
	
	@Before
	public void before() throws Exception
	{
		EmployeeBO employee = new EmployeeBO();
		employee.setEmail("test@test.com");
		employee.setFirstName("TEST_FIRST_NAME");
		employee.setLastName("TEST_LAST_NAME");
		employee.setPhoneNumber("PHONE_NUMBER");
		employee.setType("TEST");
		employeeService.saveOrUpdate(employee);
	}

	@Test
	public void testGetEmployees() throws Exception
	{
		List<EmployeeBO> employees = employeeService.findAll();
		
		Assert.assertNotNull(employees);
		
		Assert.assertTrue(employees.size() > 0);
		
		for(EmployeeBO employee : employees)
		{
			if(employee.getType().equals("TEST"))
			{
				Assert.assertEquals("TEST_FIRST_NAME", employee.getFirstName());
			}
		}
	}
	
	@Test
	public void testUpdateEmployees() throws Exception{
		List<EmployeeBO> employees = employeeService.findAll();
		
		Assert.assertNotNull(employees);
		
		Assert.assertTrue(employees.size() > 0);
		// change name to nick and then commit it to the database
		for(EmployeeBO employee : employees)
		{
			if(employee.getType().equals("TEST"))
			{
				employee.setFirstName("Nick");
				employeeService.saveOrUpdate(employee);
			}
		}
		// find all employees again, need to check to see the commit actually worked
		// once employees found, check to see if the new name for that employee is "Nick"
		employees = employeeService.findAll();
		for(EmployeeBO employee : employees)
		{
			if(employee.getType().equals("TEST"))
			{
				Assert.assertEquals("Nick", employee.getFirstName());
			}
		}
	}
	
}
