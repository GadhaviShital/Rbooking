package edu.unh.rbooking.common;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.unh.rbooking.constant.ExceptionEnum;
import edu.unh.rbooking.exception.DAOException;


/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="edu.unh.rbooking.dao.impl.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="edu.unh.rbooking.domain.Foo"/&gt;
 *          &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @author Bipin Sutariya
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@Transactional(value="coreTransactionManager")
public class GenericDaoHibernate<T, PK extends Serializable>  implements GenericDao<T, PK> {


    protected SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass())
     * from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    protected Class<T> persistentClass;
    private final String objectName;

    /**
     * Constructor that takes in a class to see which type of entity to persist
     *
     * @param persistentClass
     *            the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        objectName = this.persistentClass.getSimpleName().substring(0, this.persistentClass.getSimpleName().length()-2);
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAll() throws DAOException{
        try
        {
            List<T> list = sessionFactory.getCurrentSession().createCriteria(this.persistentClass).list();

            return list;
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"getting "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public T get(PK id)  throws DAOException{
        try
        {
        	Session session = sessionFactory.getCurrentSession();        	
            T entity = (T) session.get(this.persistentClass,
                    id);
            
            if (entity == null) {
                throw new DAOException(ExceptionEnum.NOT_FOUND_ERROR, new String[]{this.objectName});
            }
            return entity;
        }
        catch(DAOException e)
        {
            throw e;
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"getting "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public T getByName(String name) throws DAOException {
        try
        {
            String query = "FROM "+this.persistentClass.getSimpleName()+" WHERE name = '"+name+"'";
            List<T> list = (List<T>)sessionFactory.getCurrentSession().createQuery(query).list();
            if(list == null || list.size() == 0)
            {
                throw new DAOException(ExceptionEnum.NOT_FOUND_ERROR, new String[]{this.objectName});
            }
            return list.get(0);
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"getting "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) throws DAOException {

        try
        {
            T entity = (T) sessionFactory.getCurrentSession().get(this.persistentClass,
                    id);
            return entity != null;
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"checking existance of "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) throws DAOException {

        try
        {
            Session session = sessionFactory.getCurrentSession();
            object = (T)session.merge(object);
            return object;
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"saving "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void update(T object) throws DAOException {

        try
        {
            Session session = sessionFactory.getCurrentSession();
            session.update(object);
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"saving "+this.objectName}, e);
        }
    }
    /**
     * {@inheritDoc}
     */
    public void flush() throws DAOException {
        try
        {
            Session session = sessionFactory.getCurrentSession();
            session.flush();
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"flushing "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void remove(PK id) throws DAOException {
        try
        {
            Session session = sessionFactory.getCurrentSession();
            session.delete(this.get(id));
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"deleting "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getByQuery(String query) throws DAOException {
        try
        {
            List<T> list = (List<T>)sessionFactory.getCurrentSession().createQuery(query).list();
            return list;
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"getting "+this.objectName}, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void remove(T t) throws DAOException {
        try
        {
            Session session = sessionFactory.getCurrentSession();
            t = (T)session.merge(t);
            session.delete(t);
        }
        catch(Exception e)
        {
            throw new DAOException(ExceptionEnum.DEFAULT_ERROR, new String[]{"deleting "+this.objectName}, e);
        }
    }

}
