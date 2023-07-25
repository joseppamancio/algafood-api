package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Cidade", description = "Respresentação de uma cidade")
public class CidadeModel {
	
	@ApiModelProperty(example="1")
	private Long id;
	
	@ApiModelProperty(example="Uberlândia")
	private String nome;
	
	private EstadoModel estado;

}
