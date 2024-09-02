package com.titanic.ventapasajes.util.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer(){
		factory = Persistence.createEntityManagerFactory("PedidoPU");
	}
	@Produces @RequestScoped
	public EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager){
		entityManager.close();
	}
}
