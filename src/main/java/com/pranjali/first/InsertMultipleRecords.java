package com.pranjali.first;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertMultipleRecords {
	public static void main(String[] args) {

		Session session = HibernateUtility.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		Student student1 = new Student("Navya", 89);
		Student student2 = new Student("Maya", 59);
		Student student3 = new Student("Pranjal", 79);
		Student student4 = new Student("Bhumika", 99);
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);

		transaction.commit();
		session.close();

		System.out.println("Record saved successfully...");

	}
}
