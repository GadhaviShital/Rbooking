package edu.unh.rbooking.exceptionmapper;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.http.HttpStatus;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import edu.unh.rbooking.common.DTOException;
import edu.unh.rbooking.common.ErrorResponse;
import edu.unh.rbooking.exception.DAOException;
import edu.unh.rbooking.exception.ServiceException;
import edu.unh.rbooking.exception.WebServiceException;

public class ServiceExceptionMapper implements ExceptionMapper<Exception> {
	private static final Log log = LogFactory
			.getLog(ServiceExceptionMapper.class);

	private final ReloadableResourceBundleMessageSource resourceBundle;

	@Context
	private MessageContext context;

	public ServiceExceptionMapper(
			ReloadableResourceBundleMessageSource resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	/**
	 * Converts an exception to a response.
	 * 
	 * @param exception
	 *            The exception to convert.
	 * @return The HTTP response to send to the web service client.
	 */
	public Response toResponse(Exception exception) {
		log.error("Unhandled ServiceException from webService", exception);
		List<Locale> languages = context.getHttpHeaders()
				.getAcceptableLanguages();
		Locale locale = new Locale("en");

		if (languages != null && !languages.isEmpty()) {
			locale = languages.get(0);
		}

		/**
		 * Build the WebServiceException and error bean
		 */
		ErrorResponse errorResponse = new ErrorResponse();
		WebServiceException webServiceException = new WebServiceException(
				errorResponse, exception);


        String message = "";
        if (!(exception instanceof ServiceException)) {

            if ( exception.getMessage().equals("Access is denied")){
                errorResponse.setHttpCode(HttpStatus.SC_FORBIDDEN);
                errorResponse.setCode(100);
                errorResponse.setStatus("ERROR");
                message = resourceBundle.getMessage("default.error.message",
                        new String[]{"executing your request"}, locale);
            } else {
                errorResponse.setHttpCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                errorResponse.setCode(100);
                errorResponse.setStatus("ERROR");
                message = resourceBundle.getMessage("default.error.message",
                        new String[]{"executing your request"}, locale);
            }

			/* Uncomment these lines of code when troubleshooting exceptions...

				message += " (" + exception.toString() + ")";

				if (!(exception instanceof org.springframework.core.NestedRuntimeException)) {
					Throwable cause = exception.getCause();
					while (cause != null) {
						message += "; caused by " + cause.toString();
						cause = (cause.getCause() == cause) ? null : cause.getCause();
					}
				}
			 */

			errorResponse.setMessage(message);
			return webServiceException.getResponse();
		} else {
			ServiceException serviceException = (ServiceException) exception;
			Throwable cause = exception.getCause();
			Integer code = serviceException.getCode();
			Integer errorCode = 100;
			if (code != null && !"".equals(code)) {
				errorCode = code;
			}
			errorResponse.setCode(errorCode);
			errorResponse.setStatus("ERROR");
			String exceptionCode = serviceException.getName();
			if (exceptionCode == null) {
				exceptionCode = "default.error";
			}
			if (cause == null) {
				message = resourceBundle.getMessage(exceptionCode + ".message",
						serviceException.getArgs(), locale);

			} else {

				if (cause instanceof DAOException) {
					DAOException daoException = (DAOException) cause;
					exceptionCode = daoException.getName();
					if (exceptionCode == null) {
						exceptionCode = "default.error";
					}
					message = resourceBundle.getMessage(exceptionCode
							+ ".message", daoException.getArgs(), locale);

				} else if (cause instanceof DTOException) {
					DTOException dtoException = (DTOException) cause;
					exceptionCode = serviceException.getName();
					if (exceptionCode == null) {
						exceptionCode = "default.error";
					}
					message = resourceBundle.getMessage(exceptionCode
							+ ".message", dtoException.getArgs(), locale);

				} else {
					message = cause.getMessage();
				}
			}

			/* Uncomment these lines of code when troubleshooting exceptions...

				message += " (" + exception.toString() + ")";
				while (cause != null) {
					message += "; caused by " + cause.toString();
					cause = (cause.getCause() == cause) ? null : cause.getCause();
				}

            */

			errorResponse.setMessage(message);

            // Add any special case HttpStatus codes that need to be returned based on the exception enum code if necessary.
            // The default error code will be Internal Service Error (500) if not explicitly modified.
            switch(errorCode)
            {
                case 101:
                    errorResponse.setHttpCode(HttpStatus.SC_BAD_REQUEST);
                    break;
                case 103:
                    errorResponse.setHttpCode(HttpStatus.SC_NOT_FOUND);
                    break;
                default:
                    errorResponse.setHttpCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                    break;
            }
		}
		return webServiceException.getResponse();
	}

}
