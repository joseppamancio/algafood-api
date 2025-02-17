package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "cidades")
public class CidadeModel extends RepresentationModel<CidadeModel>{

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Uberlândia")
	private String nome;

	private EstadoModel estado;
}
