package com.pranjali.first;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {
	private static SessionFactory sessionFactory;// SessionFactory-Interface

	private HibernateUtility() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		return sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = null;// StandardServiceRegistry-Interface
		try {

			// Create StandardServiceRegistry
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			// StandardServiceRegistryBuilder-Class
			serviceRegistryBuilder.loadProperties("hibernate.properties");
			serviceRegistry = serviceRegistryBuilder.build();

			// Create MetadataSource
			MetadataSources metadataSources = new MetadataSources(serviceRegistry);
			// MetadataSources-Class
			metadataSources.addAnnotatedClass(Student.class);

			// Create Metadata
			Metadata metaData = metadataSources.getMetadataBuilder().build();
			// Metadata-Interface

			// Create SessionFactory
			return metaData.getSessionFactoryBuilder().build();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (serviceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
			}
			throw new RuntimeException("There was an error building the sessionFactory", e);

		}
	}
}
