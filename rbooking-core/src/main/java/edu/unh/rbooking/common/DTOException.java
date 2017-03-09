package edu.unh.rbooking.common;

import edu.unh.rbooking.constant.ExceptionEnum;
import edu.unh.rbooking.exception.RBookingException;

/**
 * Base exception class for all DTO's.  This is an unchecked exception.
 */
public class DTOException extends RBookingException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public DTOException(ExceptionEnum exceptionEnum, String[] args, Throwable t) {
    	super(exceptionEnum, args, t);
    }
	public DTOException(ExceptionEnum exceptionEnum, String[] args) {
		super(exceptionEnum, args);
	}
}
