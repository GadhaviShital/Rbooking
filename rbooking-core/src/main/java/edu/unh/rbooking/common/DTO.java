package edu.unh.rbooking.common;

import java.util.List;

import javax.ws.rs.core.UriInfo;

/**
 * <pre>
 * Generic interface for all DTO to implement.  This is intended to provide a common set of api
 * to convert Domain Objects to Business Object or Business Objects to Domain Objects.
 * The BO generic represents the Business Object.  The DO generic represents the Domain Object.
 * </pre>
 */
public interface DTO<BO, DO>
{

    /**
     * Converts a domain object to a business object.
     *
     * @param domainObject The domain object to convert to a business object.
     * @param businessObject The populated business object.
     * @return The business object.
     * @throws DTOException If there was a problem converting the domain object to a business object.
     */
    public BO convertDOToBO(DO domainObject, BO businessObject) throws DTOException;

    /**
     * Converts a business object to a domain object.
     *
     * @param businessObject The business object to convert to a domain object.
     * @param domainObject The populated domain object.
     * @return The domain object.
     * @throws DTOException If there was a problem converting the business object to a domain object.
     */
    public DO convertBOToDO(BO businessObject, DO domainObject) throws DTOException;

    /**
     * Converts a domain object to a business object.
     *
     * @param domainObject The domain object to convert to a business object.
     * @param businessClass The class of the business object.
     * @return The business object.
     * @throws DTOException If there was a problem converting the domain object to a business object.
     */
    public BO convertDOToBO(DO domainObject, Class<BO> businessClass) throws DTOException;

    /**
     * Converts a business object to a domain object.
     *
     * @param businessObject The business object to convert to a domain object.
     * @param domainClass The class of the domain object.
     * @return The domain object.
     * @throws DTOException If there was a problem converting the business object to a domain object.
     */
    public DO convertBOToDO(BO businessObject, Class<DO> domainClass) throws DTOException;
    
    /**
     * Converts a business object list to a domain object list.
     *
     * @param businessObjects The business object list to convert to a domain object.
     * @param domainClass The class of the domain object.
     * @return The domain object.
     * @throws DTOException If there was a problem converting the business objects to a domain object.
     */
    public List<DO> convertBOToDO(List<BO> businessObjects, Class<DO> domainClass) throws DTOException;
    
    /**
     * Converts a domain object list to a business object list.
     *
     * @param domainObjects The domain object list to convert to a business object.
     * @param domainClass The class of the business object.
     * @return The domain object.
     * @throws DTOException If there was a problem converting the domain object to a business object.
     */
    public List<BO> convertDOToBO(List<DO> domainObjects, Class<BO> businessClass) throws DTOException;

    /**
     * Base interface access to URIINFO information. Provides DTO's the ability to add URI data
     * to the resulting business object. Used to provide Atom:Link ref="self" information in
     * objects and collections of objects
     *
     * Example:
     *
     *   String href = uriInfo.getAbsolutePath().toString();
     *
     *   Link link = new Link();
     *   link.setRel("self");
     *   link.setHRef(href);
     *
     *   businessObject.setLink(link);
     *
     *
     * @param domainObject
     * @param businessObject
     * @param uriInfo
     * @return
     */
    public BO convertDOToBO(DO domainObject, BO businessObject, UriInfo uriInfo) throws DTOException;

}
