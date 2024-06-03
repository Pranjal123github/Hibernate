package com.pranjali.first;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class SelectOperation {
	public static void main(String[] args) {
		SelectOperation select = new SelectOperation();
		//select.fetchAllStudentDetails();
		select.getStudentById(4);
	}

	public void fetchAllStudentDetails() {
		Session session = HibernateUtility.getSessionFactory().openSession();

		Query query = session.createQuery("from Student");
		List<Student> stuList = query.list();
		for (Student student : stuList) {
			System.out.println("ID >> " + student.getId());
			System.out.println("Name >> " + student.getName());
			System.out.println("Marks >> " + student.getMarks());
		}
		session.close();
	}

	public void getStudentById(int id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Student student = session.get(Student.class, id);
		System.out.println(student);
		session.close();
	}
}
