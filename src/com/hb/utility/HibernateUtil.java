package com.hb.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


/**
*
* @author SUHEL KHAN
*/
public class HibernateUtil
{
	private static final SessionFactory sessionFactory;

	private static ServiceRegistry serviceRegistry;

	static
	{
		try
		{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th)
		{
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
		//----
//		try
//		{
//			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//
//			cfg.setProperty("hibernate.connection.url", getDbUrl());
//			cfg.setProperty("hibernate.connection.username", getDbUsername());
//			cfg.setProperty("hibernate.connection.password", getDbPassword());
//			sessionFactory = cfg.buildSessionFactory();
//
//			String connectionUrl = cfg.getProperty("hibernate.connection.url");
//			System.out.println("com.api.properties.AppProperties.dbConfiguration() ============================= connectionUrl: [" + connectionUrl + "]");
//			ISysConfig.initParams(connectionUrl);
//		} catch (Throwable th)
//		{
//			System.err.println("Enitial SessionFactory creation failed" + th);
//			throw new ExceptionInInitializerError(th);
//		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}

