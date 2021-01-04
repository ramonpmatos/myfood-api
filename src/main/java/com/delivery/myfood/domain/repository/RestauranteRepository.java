package com.delivery.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.myfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository 
	extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries {

}
