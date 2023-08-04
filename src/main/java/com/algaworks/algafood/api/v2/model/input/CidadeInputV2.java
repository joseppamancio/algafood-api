package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CidadeInput")
public class CidadeInputV2 {

	@NotBlank
	@ApiModelProperty(example="Uberlândia")
	private String nomeCidade;
	
	@NotNull
	@ApiModelProperty(example="1")
	private Long idEstado;
	
}
