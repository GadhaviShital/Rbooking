package edu.unh.rbooking.exception;

import edu.unh.rbooking.constant.ExceptionEnum;

public class ServiceException extends RBookingException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public ServiceException(ExceptionEnum exceptionEnum, String[] args, Throwable t) {
    	super(exceptionEnum, args, t);
    }
    public ServiceException(ExceptionEnum exceptionEnum, String[] args) {
    	super(exceptionEnum, args);
    } 
    public ServiceException(Throwable t)
    {
    	super(t);
    }
    public ServiceException(String message)
    {
    	super(message);
    }
}
