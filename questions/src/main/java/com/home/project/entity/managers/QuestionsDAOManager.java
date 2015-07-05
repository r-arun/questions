package com.home.project.entity.managers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.home.project.entities.Answers;
import com.home.project.entities.Questions;
import com.home.project.utilities.HibernateUtilities;

public class QuestionsDAOManager {
	public List<Questions> getQuestionsByTopic(int topicId) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Questions where topic_id = :topicId ");
		query.setParameter("topicId", topicId);
        List<Questions> questionList = query.list();
		session.close();
		return questionList;
	}
	
	public Questions getQuestionsById(int questionId) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Questions where id = :questionId ");
		query.setParameter("questionId", questionId);
        List<Questions> questionList = query.list();
		session.close();
		return questionList.get(0);
	}
	
	public void persist(Questions question) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(question);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Questions> getAllChildrenQuestions(int questionId) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Questions where parent_id = :questionId ");
		query.setParameter("questionId", questionId);
        List<Questions> questionList = query.list();
		session.close();
		return questionList;
	}
}
