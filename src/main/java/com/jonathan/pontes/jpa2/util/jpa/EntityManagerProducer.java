package com.jonathan.pontes.jpa2.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	
	//@Inject
    //private PersistenceProperties properties;
	
	private EntityManagerFactory factory;

	public EntityManagerProducer() throws Exception{
		this.factory = Persistence.createEntityManagerFactory("faculdade", PersistenceProperties.get());
	}

	@Produces
	@RequestScoped
	public EntityManager create() {
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
	
}
