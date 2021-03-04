package com.delivery.myfood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	DADOS_INVALIDOS("/dados-invalidos","Dados Inválidos"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","Mensagem Incompreensível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado","Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio","Violação da regra de negócio"),
	PARAMETRO_INVALIDO("/parametro-invalido","Parametro Inválido");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://myfood.com.br" + path;
		this.title = title;
	}
}
