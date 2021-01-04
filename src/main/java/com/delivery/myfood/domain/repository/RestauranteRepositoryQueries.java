package com.delivery.myfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.delivery.myfood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}