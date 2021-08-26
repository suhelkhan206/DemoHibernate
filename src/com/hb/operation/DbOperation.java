package com.hb.operation;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.hb.co.User;
import com.hb.utility.AppValidate;
import com.hb.utility.HibernateUtil;

/**
*
* @author SUHEL KHAN
*/

public class DbOperation {
	
	public static void persist(Object entity)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			session.persist(entity);
			session.getTransaction().commit();
		}
	}

	public static void delete(Object entity)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		}
	}

	public static void merge(Object entity)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			Object updatedEntity = session.merge(entity);
			session.getTransaction().commit();
		}
	}
	
	private static void persist(List<?> entityList)
	{
		/*if (AppValidate.isEmpty(entityList))
		{
			return;
		}*/

		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();

			for (Object object : entityList)
			{
				if (object != null)
				{
					session.persist(object);
				}
			}

			session.getTransaction().commit();
		}
	}
	
	public static void saveLogs(String logText)
    {
        try
        {
            User appLog = new User();
            DbOperation.persist(appLog);
        } 
        catch (Exception exception)
        {
         // you can save error here 
        }
    }

	
	public static User getUserById(final String id)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Query query = session.createNativeQuery("SELECT * FROM users ul WHERE ul.id= :id").addEntity(User.class).setParameter("id", id);
			List<User> result = query.getResultList();

			if (AppValidate.isEmpty(result))
			{
				return null;
			} else
			{
				return result.get(0);
			}
		}

	}


}
