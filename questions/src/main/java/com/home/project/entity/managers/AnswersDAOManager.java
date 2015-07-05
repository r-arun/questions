package com.home.project.entity.managers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.home.project.entities.Answers;
import com.home.project.utilities.HibernateUtilities;


public class AnswersDAOManager {
	public List<Answers> getAnswersForQuestion(int questionId) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Answers where question_id = :questionId ");
		query.setParameter("questionId", questionId);
		List<Answers> answersList = query.list();
		session.close();
		return answersList;
	}
	
	public void persist(Answers answer) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(answer);
		session.getTransaction().commit();
		session.close();
		
	}

}
