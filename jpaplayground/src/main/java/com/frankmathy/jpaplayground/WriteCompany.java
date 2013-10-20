package com.frankmathy.jpaplayground;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.frankmathy.jpaplayground.model.Company;
import com.frankmathy.jpaplayground.model.Person;

public class WriteCompany {

	private static final String PERSISTENCE_UNIT_NAME = "persistence";
	private static EntityManagerFactory factory;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Company company = new Company();
		company.setName("ACME");
		
		Person p = new Person();
		p.setFirstName("Frank");
		p.setLastName("Mathy");
		p.setCompany(company);
		
		em.persist(p);
		em.persist(company);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
