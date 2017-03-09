package edu.unh.rbooking.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.unh.rbooking.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;

/**
 *
 * @param <B>
 * @param <D>
 * @param <ID>
 */


public interface GenericController<B,D,ID extends Serializable> {
	
	/**
     * Generic method to save an object - handles both update and insert.
     * @param B the object to save
     * @return the updated object
     * @throws ServiceException
     */
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public B saveOrUpdate(B business) throws ServiceException;

	/**
     * Generic method to save an object - handles both update and insert.
     * @param list of object the objects to save
     * @return the updated objects
     * @throws ServiceException
     */
	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<B> saveOrUpdate(final List<B> business) throws ServiceException;

	/**
     * Generic method to delete an object based on class and id
     * @param the object to remove
     * @throws ServiceException
     */
	@DELETE
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public void delete(final B business) throws ServiceException;

	/**
     * Generic method to delete an object based on class and id
     * @param id the identifier (primary key) of the object to remove
     * @throws ServiceException
     */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public void delete(@PathParam("id") ID id) throws ServiceException;
	
	/**
     * Generic method to delete an object based on class and id
     * @param list of the objects to remove
     * @throws ServiceException
     */
	@DELETE
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public void delete(final List<B> busineses) throws ServiceException;

	/**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @return List of populated objects
     * @throws ServiceException
     */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws ServiceException;

	/**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     * @throws ServiceException
     */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@PreAuthorize("hasPermission(#B,#this.getThis().getPermissionGroup()+':view')")
	public B findById(@PathParam("id") ID id) throws ServiceException;
	
	/**
     * Generic method to get an object based on class and name. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     * @throws ServiceException
     */
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@PreAuthorize("hasPermission(#B,#this.getThis().getPermissionGroup()+':view')")
	public B findByName(@PathParam("name") String name) throws ServiceException;


}