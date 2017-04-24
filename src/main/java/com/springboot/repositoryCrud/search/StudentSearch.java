package com.springboot.repositoryCrud.search;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.repositoryCrud.entity.Student;

@Repository
@Transactional
public class StudentSearch {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Student> search(String text) {

		// get the full text entity manager

		Session session = this.sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = org.hibernate.search.Search.getFullTextSession(session);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Student.class)
				.get();

		// a very basic query by keywords
		org.apache.lucene.search.Query query = queryBuilder.keyword()
				.onFields("fname", "lname", "contact", "address.city", "address.country", "address.zip").matching(text).createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.Query hibernateQuery = fullTextSession.createFullTextQuery(query, Student.class);

		// execute search and return results (sorted by relevance as default)
		@SuppressWarnings("unchecked")
		List<Student> results = hibernateQuery.list();
		System.out.println("student informaion " +results.toString());
		return results;
	} // method search

}
