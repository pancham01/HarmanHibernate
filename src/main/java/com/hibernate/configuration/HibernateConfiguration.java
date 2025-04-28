package com.hibernate.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfiguration {

	public static SessionFactory getSessionFactory() {

		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/harsh");
		properties.put(Environment.JAKARTA_JDBC_USER, "root");
		properties.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.FORMAT_SQL, "true");
		return new MetadataSources(new StandardServiceRegistryBuilder().applySettings(properties).build())
				.addAnnotatedClasses(com.hibernate.model.Employee.class,com.hibernate.model.Address.class).buildMetadata().buildSessionFactory();
	}

}
