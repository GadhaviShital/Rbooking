package edu.unh.rbooking.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.constant.ExceptionEnum;
import edu.unh.rbooking.exception.ServiceException;

/**
 * 
 * This class serves as the Base class for all other Managers - namely to hold
 * 
 * common CRUD methods that they might all use. You should only need to extend
 * 
 * this class when your require custom CRUD logic.
 * 
 * @author Bipin Sutariya
 * 
 * @param <T>
 *            a type variable
 * 
 * @param <PK>
 *            the primary key for that type
 */

public class GenericServiceImpl<B, D, PK extends Serializable> implements
		GenericService<B, D, PK> {

	/**
	 * 
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 
	 * GenericDao instance, set by constructor of this class
	 */

	protected GenericDao<D, PK> genericDao;

	/**
	 * GenericDTO instance, set by constructor of this class
	 */
	protected DTO<B, D> dto;
	private Class<B> businessClass;
	private Class<D> domainClass;
	private final String businessObjectName;
	private final String domainObjectName;
	
	/**
	 * 
	 * Public constructor for creating a new GenericServiceImpl.
	 * 
	 * @param genericDao
	 *            the GenericDao to use for persistence
	 */

	public GenericServiceImpl(final GenericDao<D, PK> genericDao, DTO<B, D> dto) {
		
		this.genericDao = genericDao;		
		this.dto = dto;

		this.businessClass = (Class<B>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.domainClass = (Class<D>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		
		businessObjectName = this.businessClass.getSimpleName().substring(0, this.businessClass.getSimpleName().length()-2);
		domainObjectName = this.domainClass.getSimpleName().substring(0, this.domainClass.getSimpleName().length()-2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public B saveOrUpdate(B business) throws ServiceException {
		try {
			D d = dto.convertBOToDO(business, this.domainClass);
			d = this.genericDao.save(d);
			return dto.convertDOToBO(d, this.businessClass);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public List<B> saveOrUpdate(List<B> busineses) throws ServiceException {
		try {
			List<B> bs = new ArrayList<B>();
			for (B business : busineses) {
				D d = dto.convertBOToDO(business, this.domainClass);
				d = this.genericDao.save(d);
				B b = dto.convertDOToBO(d, this.businessClass);
				bs.add(b);
			}

			return bs;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public void update(B business) throws ServiceException {
		try {
			D d = dto.convertBOToDO(business, this.domainClass);
			this.genericDao.update(d);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public void delete(PK id) throws ServiceException {
		try {
			this.genericDao.remove(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public void delete(B business) throws ServiceException {
		try {
			D d = dto.convertBOToDO(business, this.domainClass);
			this.genericDao.remove(d);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager", rollbackFor = ServiceException.class)
	public void delete(List<B> busineses) throws ServiceException {
		try {
			for (B business : busineses) {
				D d = dto.convertBOToDO(business, this.domainClass);
				this.genericDao.remove(d);
			}

		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager")
	public List<B> findAll() throws ServiceException {
		try {
			List<D> list = this.genericDao.getAll();
			List<B> bs = new ArrayList<B>();
			for (D d : list) {
				B b = dto.convertDOToBO(d, this.businessClass);
				bs.add(b);
			}
			return bs;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value="coreTransactionManager")
	public B findById(PK id) throws ServiceException {
		try {
			D d = this.genericDao.get(id);
			return dto.convertDOToBO(d, this.businessClass);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(value="coreTransactionManager")
	public B findByName(String name) throws ServiceException {
		try {
			String query = "FROM " + domainClass.getSimpleName()
					+ " WHERE name='" + name + "'";
			List<D> list = this.genericDao.getByQuery(query);
			if (list != null && list.size() > 0) {
				B b = dto.convertDOToBO(list.get(0), this.businessClass);
				return b;
			}

			throw new ServiceException(ExceptionEnum.NOT_FOUND_ERROR,
					new String[] { this.businessObjectName });
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}	
}