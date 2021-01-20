package com.delivery.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.delivery.myfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
		extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

	@Query("select distinct r from Restaurante r join r.cozinha left join fetch r.formasPagamento")
	List<Restaurante> findAll();
}
