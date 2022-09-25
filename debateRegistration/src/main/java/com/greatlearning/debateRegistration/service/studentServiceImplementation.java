package com.greatlearning.debateRegistration.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.debateRegistration.entity.student;

@Repository

public class studentServiceImplementation implements studentService {
	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	public studentServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Override
	@Transactional
	public List<student> findAll() {
		Transaction tx = session.beginTransaction();

		List<student> students = session.createQuery("from student").list();
		tx.commit();

		return students;
	}

	@Override
	@Transactional
	public student findById(int theId) {
		student Student = new student();

		Transaction tx = session.beginTransaction();

		Student = session.get(student.class, theId);
		tx.commit();

		return Student;
	}

	@Override
	@Transactional
	public void save(student thestudent) {
		Transaction tx = session.beginTransaction();
		session.save(thestudent);
		tx.commit();

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		Transaction tx = session.beginTransaction();
		student Student = session.get(student.class, theId);
		session.delete(Student);
		tx.commit();

	}

}
