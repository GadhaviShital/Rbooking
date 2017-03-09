package edu.unh.rbooking.exception;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;

import edu.unh.rbooking.common.ErrorResponse;

public class WebServiceException extends WebApplicationException
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ErrorResponse errorResponse;

    public WebServiceException(ErrorResponse errorResponse, Throwable cause)
    {
        super(cause);
        this.errorResponse = errorResponse;
    }

    /**
     * method to return the serialized bean
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,
               MediaType.APPLICATION_XML})
    public Response getResponse()
    {
        Response.ResponseBuilder responseBuilder = new ResponseBuilderImpl();
        responseBuilder.status(errorResponse.getHttpCode());
        responseBuilder.entity(errorResponse);
        return responseBuilder.build();
    }

}