package edu.unh.rbooking.common;

import java.io.Serializable;
import java.util.List;

import edu.unh.rbooking.exception.DAOException;


/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * <p>Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @author Bipin Sutariya
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */

public interface GenericDao<T, PK extends Serializable> {

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @return List of populated objects
     * @throws DAOException
     */
    public List<T> getAll() throws DAOException;

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     * @throws DAOException
     */
    public T get(PK id) throws DAOException;
    
    /**
     * Generic method to get an object based on class and name. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param name of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     * @throws DAOException
     */
    public T getByName(String name) throws DAOException;

    /**
     * Checks for existence of an object of type T using the id arg.
     * @param id the id of the entity
     * @return - true if it exists, false if it doesn't
     * @throws DAOException
     */
    public boolean exists(PK id) throws DAOException;

    /**
     * Generic method to save an object - handles both update and insert.
     * @param object the object to save
     * @return the persisted object
     * @throws DAOException
     */
    public T save(T object) throws DAOException;

    /**
     * Generic method to ONLY update an object. Useful when you
     * do not want to INSERT new records.
     * @param object the object to save
    * @throws DAOException
     */
    public void update(T object) throws DAOException;
    /**
     * Generic method to flush the session state
     * @throws DAOException
     */
    public void flush() throws DAOException;

    /**
     * Generic method to delete an object based on class and id
     * @param id the identifier (primary key) of the object to remove
     * @throws DAOException
     */
    public void remove(PK id) throws DAOException;
    
    /**
     * Generic method to find an object based on query
     * @param query
     * @return
     * @throws DAOException
     */
    public List<T> getByQuery(String query) throws DAOException;
    
    /**
     * Generic method to remove Object
     * @param object the object to remove
     * @throws DAOException
     * 
     */
    public void remove(T t) throws DAOException;

}