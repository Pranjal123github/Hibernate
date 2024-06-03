package com.pranjali.first;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateOperation {

	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 5);
		student.setName("Kalyani");
		student.setMarks(90);
		session.update(student);
		transaction.commit();
		session.close();
		System.out.println("Record Updated successfully...");

	}

}
