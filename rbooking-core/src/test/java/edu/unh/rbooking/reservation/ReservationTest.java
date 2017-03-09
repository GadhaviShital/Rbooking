package edu.unh.rbooking.reservation;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.credential.CredentialBO;
import edu.unh.rbooking.credential.CredentialService;
import edu.unh.rbooking.customer.CustomerBO;
import edu.unh.rbooking.employee.EmployeeBO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/rbooking-core-context.xml")
@TransactionConfiguration( transactionManager="coreTransactionManager", defaultRollback = false)
@Transactional(value="coreTransactionManager")
public class ReservationTest {
	
	@Resource(name="reservationService")
	ReservationService reservationService;

	@Resource(name = "credentialService")
	CredentialService credentailService;
	
	//@Before
	public void before() throws Exception
	{
		ReservationBO reservation = new ReservationBO();
		
		reservation.setDate(new Timestamp(System.currentTimeMillis()));
		
		reservation.setNumberPeople(4);
		reservation.setTime("4:00pm");
		
		CustomerBO customer = new CustomerBO();
		customer.setEmail("email");
		customer.setFirstName("firstname");
		customer.setLastName("lastname");
		customer.setPhone("333");
		
		reservation.setCustomer(customer);
		
		
		reservationService.saveOrUpdate(reservation);
		List<ReservationBO> list = reservationService.findAll();
		
		String result = new ObjectMapper().writeValueAsString(list);
		
		System.out.println(result);
	}

	@Test
	public void testGetEmployees() throws Exception
	{
		CredentialBO credential = new CredentialBO();
		credential.setUserName("bipin");
		credential.setPassword("bipin");
		EmployeeBO employee = credentailService.login(credential);
		String result = new ObjectMapper().writeValueAsString(employee);
		
		System.out.println(result);
	}
		
}
