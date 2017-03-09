package edu.unh.rbooking.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.UriInfo;

import org.dozer.Mapper;

import edu.unh.rbooking.constant.ExceptionEnum;

/**
 * <pre>
 * This implementation internally uses the DozerBeanMapper to perform a
 * mapping of attributes from a source object to a destination object.
 * Please refer to the following link for any Dozer related inquiries.
 * </pre>
 * 
 * @link http://dozer.sourceforge.net/
 * @see edu.unh.rbooking.common.DTO
 */
public class DozerDTOImpl<BO, DO> implements DTO<BO, DO> {

	/**
	 * The DozerBeanMapper that is used to convert Domain Objects to Business
	 * Objects and Business Objects to Domain Objects.
	 */
	@Resource(name = "rbookingDozerBeanMapper")
	protected Mapper rbookingDozerBeanMapper;

	/**
	 * Sets the dozer bean mapper for the dto to use.
	 * 
	 * @param rbookingDozerBeanMapper
	 *            The dozer bean mapper for the dto to use.
	 */
	public void setRbookingDozerBeanMapper(Mapper rbookingDozerBeanMapper) {
		this.rbookingDozerBeanMapper = rbookingDozerBeanMapper;
	}

	/**
	 * Default constructor
	 */
	public DozerDTOImpl() {
	}

	/**
	 * @see edu.unh.rbooking.common.DTO#convertDOToBO(Object, Object)
	 */
	public BO convertDOToBO(DO domain, BO business) throws DTOException // TODO
																		// eliminate
																		// second
																		// parameter
	{
		try {
			rbookingDozerBeanMapper.map(domain, business);
		} catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ domain.getClass().getSimpleName() + " to "
							+ business.getClass().getSimpleName() }, exception);
		}

		return business;
	}

	/**
	 * @see edu.unh.rbooking.common.DTO#convertBOToDO(Object, Object)
	 */
	public DO convertBOToDO(BO business, DO domain) throws DTOException // TODO
																		// eliminate
																		// second
																		// parameter
	{
		try {
			rbookingDozerBeanMapper.map(business, domain);
		} catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ business.getClass().getSimpleName() + " to "
							+ domain.getClass().getSimpleName() }, exception);
		}

		return domain;
	}

	/**
	 * @see com.philips.teletrol.common.DTO#convertDOToBO(Object, Class<BO>)
	 */
	public BO convertDOToBO(DO domain, Class<BO> businessClass)
			throws DTOException {
		BO business = null;

		try {
			business = rbookingDozerBeanMapper.map(domain, businessClass);
		} catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ domain.getClass().getSimpleName() + " to "
							+ businessClass.getSimpleName() }, exception);
		}

		return business;
	}

	/**
	 * @see com.philips.teletrol.common.DTO#convertBOToDO(Object, Class<DO>)
	 */
	public DO convertBOToDO(BO business, Class<DO> domainClass)
			throws DTOException {
		DO domain;

		try {
			domain = rbookingDozerBeanMapper.map(business, domainClass);
		} catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ business.getClass().getSimpleName() + " to "
							+ domainClass.getSimpleName() }, exception);
		}

		return domain;
	}

	/**
	 * @see com.philips.teletrol.common.DTO#convertBOToDO(List<Object>, Class<DO>)
	 */
	@Override
	public List<DO> convertBOToDO(List<BO> businessObjects,
			Class<DO> domainClass) throws DTOException {
		
		List<DO> dos = new ArrayList<DO>();
		try
		{
			for(BO bo : businessObjects)
			{
				dos.add(convertBOToDO(bo, domainClass));
			}
		}catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ businessObjects.get(0).getClass().getSimpleName() + " to "
							+ domainClass.getSimpleName() }, exception);
		}
		
		return dos;
	}
	
	/**
	 * @see com.philips.teletrol.common.DTO#convertDOToBO(List<Object>, Class<BO>)
	 */
	@Override
	public List<BO> convertDOToBO(List<DO> domainObjects,
			Class<BO> businessClass) throws DTOException {
		List<BO> bos = new ArrayList<BO>();
		try
		{
			for(DO domain : domainObjects)
			{
				bos.add(convertDOToBO(domain, businessClass));
			}
		}catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ domainObjects.get(0).getClass().getSimpleName() + " to "
							+ businessClass.getSimpleName() }, exception);
		}
		
		return bos;
	}
	
	public BO convertDOToBO(DO domainObject, BO businessObject, UriInfo uriInfo)
			throws DTOException {
		try {
			rbookingDozerBeanMapper.map(domainObject, businessObject);
		} catch (Exception exception) {
			throw new DTOException(ExceptionEnum.DEFAULT_ERROR,
					new String[] { "converting "
							+ domainObject.getClass().getSimpleName() + " to "
							+ businessObject.getClass().getSimpleName() },
					exception);
		}

		return businessObject;
	}

}
