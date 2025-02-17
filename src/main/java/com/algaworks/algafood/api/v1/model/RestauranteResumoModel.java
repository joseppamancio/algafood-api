package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Relation(collectionRelation = "restaurantes")
public class RestauranteResumoModel extends RepresentationModel<RestauranteResumoModel>{
    private Long id;
    private String nome;
}  
