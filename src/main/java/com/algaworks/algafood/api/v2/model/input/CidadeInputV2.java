package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInputV2 {

	@NotBlank
	@Schema(example = "Uberlândia")
	private String nomeCidade;
	
	@NotNull
	private Long idEstado;
	
}
