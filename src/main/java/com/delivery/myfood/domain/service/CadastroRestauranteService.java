package com.delivery.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.myfood.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.myfood.domain.model.Cozinha;
import com.delivery.myfood.domain.model.Restaurante;
import com.delivery.myfood.domain.repository.CozinhaRepository;
import com.delivery.myfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o código %d", cozinhaId)));
		

		restaurante.setCozinha(cozinha);

		return restauranteRepository.save(restaurante);
	}
}
