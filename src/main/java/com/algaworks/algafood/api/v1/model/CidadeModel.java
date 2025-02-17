package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "cidades")
@Setter
@Getter
@Schema(name = "CidadeModel")
public class CidadeModel extends RepresentationModel<CidadeModel> {

	@Schema(example = "1", description = "ID da cidade")
	private Long id;

	@Schema(example = "Uberlândia", description = "Nome da cidade")
	private String nome;

	private EstadoModel estado;
}