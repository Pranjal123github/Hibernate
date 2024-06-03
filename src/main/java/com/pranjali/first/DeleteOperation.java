package com.pranjali.first;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteOperation {
	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 4);
		session.delete(student);
		transaction.commit();
		session.close();
		System.out.println("Record Deleted Successfully...");
	}
}
