package com.algaworks.algafood.api.v2.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Relation(collectionRelation = "cozinhas")
public class CozinhaModelV2 extends RepresentationModel<CozinhaModelV2> {
    private Long idCozinha;
    private String nomeCozinha;
}  