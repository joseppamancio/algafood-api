package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput {
	
	@NotBlank
	@ApiModelProperty(example = "Minas Gerais", required = true)
	private String nome;

}
