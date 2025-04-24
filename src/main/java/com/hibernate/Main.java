package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.configuration.HibernateConfiguration;
import com.hibernate.model.Address;
import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {
		Address add1 = new Address("GZB", "UP");
		Address add2 = new Address("Noida", "UP");
		Address add3 = new Address("Patiala", "P");
		List<Address> list = new ArrayList<Address>();
		list.add(add1);
		list.add(add2);
		list.add(add3);

		Employee e = new Employee();
		e.setName("Vikas");
		e.setSalary(33333);
		e.setGender("Male");
		e.setAddresses(list);

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(add1);
		session.persist(add2);
		session.persist(add3);
		session.persist(e);
		tx.commit();

	}

}
