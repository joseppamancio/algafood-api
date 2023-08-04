package com.algaworks.algafood.api.v1.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput {

	@NotBlank
	@ApiModelProperty(example="Uberlândia", required=true)
	private String nome;
	
	@Valid
	@NotNull
	private EstadoIdInput estado;
	
}
