package com.pranjali.first;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertOperation {
	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setId(101);
		student.setName("Kavya");
		student.setMarks(99);
		session.save(student);
		transaction.commit();
		session.close();
		System.out.println("Record saved successfully...");

	}

}
