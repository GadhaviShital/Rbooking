package edu.unh.rbooking.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.unh.rbooking.common.GenericService;
import edu.unh.rbooking.exception.ServiceException;

public abstract class GenericControllerImpl<B,D, PK extends Serializable> implements
		GenericController<B,D,PK> {

	/**
	 * 
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 
	 * GenericService instance, set by constructor of this class
	 */

	protected GenericService<B,D,PK> genericService;

	/**
	 * GenericDTO instance, set by constructor of this class
	 */

	private Class<B> businessClass;
	private final String businessObjectName;
	
	/**
	 * 
	 * Public constructor for creating a new GenericControllerImpl.
	 * 
	 * @param genericService
	 *            the GenericService to use for business logic
	 */

	public GenericControllerImpl(final GenericService genericService) {
		
		this.genericService = genericService;

		this.businessClass = (Class<B>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		businessObjectName = this.businessClass.getSimpleName().substring(0, this.businessClass.getSimpleName().length()-2);

	}

	/**
	 * {@inheritDoc}
	 */

	public B saveOrUpdate(B business) throws ServiceException {
		return genericService.saveOrUpdate(business);
	}

	/**
	 * {@inheritDoc}
	 */

	public List<B> saveOrUpdate(List<B> businesses) throws ServiceException {
		return genericService.saveOrUpdate(businesses);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(PK id) throws ServiceException {
		genericService.delete(id);

	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(B business) throws ServiceException {
		genericService.delete(business);
	}

	/**
	 * {@inheritDoc}
	 */

	public void delete(List<B> businesses) throws ServiceException {
		genericService.delete(businesses);
	}

	/**
	 * {@inheritDoc}
	 */

	public Response findAll() throws ServiceException {
		List<B>  objects = genericService.findAll();
		return Response.ok(objects).build();
	}

	/**
	 * {@inheritDoc}
	 */

	public B findById(PK id) throws ServiceException {
		return genericService.findById(id);
	}

	public B findByName(String name) throws ServiceException {
		return genericService.findByName(name);
	}	
}