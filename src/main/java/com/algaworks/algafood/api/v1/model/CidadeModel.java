package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "cidades")
@ApiModel(value = "Cidade", description = "Respresentação de uma cidade")
public class CidadeModel extends RepresentationModel<CidadeModel>{
	
	@ApiModelProperty(example="1")
	private Long id;
	
	@ApiModelProperty(example="Uberlândia")
	private String nome;
	
	private EstadoModel estado;

}
