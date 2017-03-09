package edu.unh.rbooking.exception;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import edu.unh.rbooking.constant.ExceptionEnum;

public abstract class RBookingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int code;
	private final String name;
	private final String message;
	private final String[] args;
	
    public RBookingException(ExceptionEnum exceptionEnum, String[] args, Throwable t) {
        super(t);
        ReloadableResourceBundleMessageSource resourceBundle = new ReloadableResourceBundleMessageSource();
        resourceBundle.setBasename("classpath:error");
		this.code = exceptionEnum.getCode();
		this.name = exceptionEnum.getName();
        this.message = resourceBundle.getMessage(exceptionEnum.getName()+".message", args, null);
		this.args = args;
    }

    public RBookingException(ExceptionEnum exceptionEnum, String[] args) {
        ReloadableResourceBundleMessageSource resourceBundle = new ReloadableResourceBundleMessageSource();
        resourceBundle.setBasename("classpath:error");
		this.code = exceptionEnum.getCode();
		this.name = exceptionEnum.getName();
		this.message = resourceBundle.getMessage(exceptionEnum.getName()+".message", args, null);
		this.args = args;
    }

	public RBookingException(Throwable t)
	{
		super(t);
        this.code = ExceptionEnum.DEFAULT_ERROR.getCode();
        this.name = ExceptionEnum.DEFAULT_ERROR.getName();
		this.message = null;
        this.args = null;
	}
	
	public RBookingException(String message)
	{
        this.code = ExceptionEnum.DEFAULT_ERROR.getCode();
        this.name = ExceptionEnum.DEFAULT_ERROR.getName();
		this.message = message;
        this.args = null;
	}
	
	public RBookingException(String message, Throwable t)
	{
		super(message, t);
        this.code = ExceptionEnum.DEFAULT_ERROR.getCode();
        this.name = ExceptionEnum.DEFAULT_ERROR.getName();
		this.message = message;
		this.args = null;
	}
	public String[] getArgs() {
		return args;
	}
	public String getName() {
		return name;
	}
	public String getMessage() {		
		return message;
	}
	public String getDetailMessage() { return super.getMessage(); }
	public int getCode() {
		return code;
	}
}
