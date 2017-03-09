package edu.unh.rbooking.exception;

import edu.unh.rbooking.constant.ExceptionEnum;

/**
 * Base exception class for all DAO's.  This is an unchecked exception.
 */
public class DAOException extends RBookingException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public DAOException(ExceptionEnum exceptionEnum, String[] args, Throwable t) {
    	super(exceptionEnum, args, t);
    }
    public DAOException(ExceptionEnum exceptionEnum, String[] args) {
    	super(exceptionEnum, args);
    }
    public DAOException(Throwable t)
    {
    	super(t);
    }
    public DAOException(String message)
    {
    	super(message);
    }
}
