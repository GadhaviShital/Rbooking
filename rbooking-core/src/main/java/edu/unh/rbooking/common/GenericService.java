package edu.unh.rbooking.common;

import java.io.Serializable;
import java.util.List;

import edu.unh.rbooking.exception.ServiceException;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 *
 * <p>Extend this interface if you want typesafe (no casting necessary) managers
 * for your domain objects.
 *
 * @author Bipin Sutariya
 * @param <B> a type variable for Business Object
 * @param <D> a type variable for Domain Object
 * @param <ID> the primary key for that type
 */

public interface GenericService<B, D, ID extends Serializable> {
	
	/**
     * Generic method to save an object - handles both update and insert.
     * @param business the object to save
     * @return the updated object
     * @throws ServiceException
     */
	public B saveOrUpdate(final B business) throws ServiceException;

	/**
     * Generic method to save an object - handles both update and insert.
     * @param business of object the objects to save
     * @return the updated objects
     * @throws ServiceException
     */
	public List<B> saveOrUpdate(final List<B> business) throws ServiceException;

	/**
	 * Ability to update only objects.
	 * @param business
	 * @throws ServiceException
     */
	public void update(final B business) throws ServiceException;

	/**
     * Generic method to delete an object based on class and id
     * @param business object to remove
     * @throws ServiceException
     */
	public void delete(final B business) throws ServiceException;

	/**
     * Generic method to delete an object based on class and id
     * @param id the identifier (primary key) of the object to remove
     * @throws ServiceException
     */
	public void delete(final ID id) throws ServiceException;
	
	/**
     * Generic method to delete an object based on class and id
     * @param list of the objects to remove
     * @throws ServiceException
     */
	public void delete(final List<B> busineses) throws ServiceException;

	/**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @return List of populated objects
     * @throws ServiceException
     */
	public List<B> findAll() throws ServiceException;

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
	public B findById(final ID id) throws ServiceException;
	
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
	public B findByName(final String name) throws ServiceException;


}