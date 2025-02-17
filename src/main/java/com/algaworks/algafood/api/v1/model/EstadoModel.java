package com.algaworks.algafood.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@Schema(name = "EstadoModel")
public class EstadoModel extends RepresentationModel<EstadoModel> {

	@Schema(example = "1", description = "ID do estado")
	private Long id;

	@Schema(example = "Minas Gerais", description = "Nome do estado")
	private String nome;
}
