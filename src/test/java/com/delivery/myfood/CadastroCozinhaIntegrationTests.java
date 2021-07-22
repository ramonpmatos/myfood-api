package com.delivery.myfood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.delivery.myfood.domain.exception.CozinhaNaoEncontradaException;
import com.delivery.myfood.domain.exception.EntidadeEmUsoException;
import com.delivery.myfood.domain.model.Cozinha;
import com.delivery.myfood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIntegrationTests {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Test
	void deveAtribuirIdQuandoCadastrarCozinhaComDadosCorretos() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Japonesa");
		
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	void deveFalharQaundoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		ConstraintViolationException erroEsperado = 
				assertThrows(ConstraintViolationException.class, () -> cadastroCozinha.salvar(novaCozinha));
		
		assertThat(erroEsperado).isNotNull();
	}
	
	
	@Test
	public void deveFalharQuandoExcluirCozinhaEmUso() {
		EntidadeEmUsoException erroEsperado = 
				assertThrows(EntidadeEmUsoException.class, () -> cadastroCozinha.excluir(1L));
		
		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalharQuandoExcluirCozinhaInexistente() {
		CozinhaNaoEncontradaException erroEsperado = 
				assertThrows(CozinhaNaoEncontradaException.class, () -> cadastroCozinha.excluir(100L));
		
		assertThat(erroEsperado).isNotNull();
	}

}
