package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.algaworks.algafood.core.validation.Multiplo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoInput {

	@NotNull
	private Long produtoId;

	@NotNull
	@PositiveOrZero
	@Multiplo(numero = 1)
	private Integer quantidade;

	private String observacao;

}
