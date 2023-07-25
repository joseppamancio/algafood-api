package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class CozinhaInput {

	@NotBlank
	@ApiModelProperty(example = "Brasileira", required = true)
	private String nome;
	
}
