package com.algaworks.algafood.api.v2.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "cidades")
@ApiModel(value = "CidadeModel", description = "Respresentação de uma cidade")
public class CidadeModelV2 extends RepresentationModel<CidadeModelV2>{
	
	@ApiModelProperty(example="1")
	private Long idCidade;
	
	@ApiModelProperty(example="Uberlândia")
	private String nomeCidade;
	
	private Long idEstado;
	
	private String nomeEstado;

}
