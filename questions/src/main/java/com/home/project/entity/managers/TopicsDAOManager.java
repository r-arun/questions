package com.home.project.entity.managers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.home.project.entities.Questions;
import com.home.project.entities.Topics;
import com.home.project.utilities.HibernateUtilities;

public class TopicsDAOManager {
	public void createTopic(final String topicName) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Topics topic = new Topics();
		topic.setTopicName(topicName);
		session.save(topic);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Topics> getTopicList() {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Topics> topicList = session.createQuery("from Topics").list();
		session.close();
		return topicList;
	}
	
	public List<Questions> getParentQuestionsInATopic(int topicId) {
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Questions where topic_id = :topicId and parent_id IS NULL ");
		query.setParameter("topicId", topicId);
        List<Questions> questionList = query.list();
		session.close();
		return questionList;
		
	}
}