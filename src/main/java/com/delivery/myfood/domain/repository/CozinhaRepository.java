package com.delivery.myfood.domain.repository;

import org.springframework.stereotype.Repository;

import com.delivery.myfood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

}
