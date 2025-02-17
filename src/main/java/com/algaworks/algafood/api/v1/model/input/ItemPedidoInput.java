package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import com.algaworks.algafood.core.validation.Multiplo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;

@Setter
@Getter
public class ItemPedidoInput {

	@Schema(example = "1")
	@NotNull
	private Long produtoId;

	@Schema(example = "2")
	@Min(1)
	@NotNull
	@PositiveOrZero
	@Multiplo(numero = 1)
	private Integer quantidade;

	@Schema(example = "Menos picante, por favor")
	private String observacao;

}