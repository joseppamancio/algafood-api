package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "grupos")
public class GrupoModel extends RepresentationModel<GrupoModel> {
	private Long id;
	private String nome;
}
