package edu.unh.rbooking.common;

import edu.unh.rbooking.constant.ExceptionEnum;
import edu.unh.rbooking.exception.DAOException;
import edu.unh.rbooking.exception.ServiceException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: USB16823
 * Date: 10/31/14
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionTest {

	@Test
	public void testServiceException_cause()
	{
        Exception e = new Exception();

		try
		{
			throw new ServiceException(ExceptionEnum.VALIDATION_ERROR, null, e);
		}
		catch(ServiceException exception)
		{
            assertEquals(exception.getCause(), e);
		}
	}


	@Test
	public void testDAOException_cause()
	{
        Exception e = new Exception();

		try
		{
			throw new DAOException(ExceptionEnum.VALIDATION_ERROR, null, e);
		}
		catch(DAOException exception)
		{
            assertEquals(exception.getCause(), e);
		}
	}
}
