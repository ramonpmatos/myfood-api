package com.delivery.myfood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.delivery.myfood.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Cozinha> listar(){
		
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
		
	}
}
