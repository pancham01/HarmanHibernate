package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.configuration.HibernateConfiguration;
import com.hibernate.model.Address;
import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {
		Address add1 = new Address("GZB", "UP");
		Employee e = new Employee();
		e.setName("Vikas");
		e.setSalary(33333);
		e.setGender("Male");
		e.setAddress(add1);
		add1.setEmployee(e);
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

//		session.persist(add1);
		session.persist(e);
		tx.commit();
		
		

	}

}
