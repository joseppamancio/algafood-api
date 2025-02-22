package com.algaworks.algafood.api.v2.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Relation(collectionRelation = "cozinhas")
public class CozinhaModelV2 extends RepresentationModel<CozinhaModelV2> {

    @Schema(example = "1")
    private Long idCozinha;
    
    @Schema(example = "Brasileira")
    private String nomeCozinha;
    
}  