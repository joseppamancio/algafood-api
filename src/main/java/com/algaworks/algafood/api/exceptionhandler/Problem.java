package com.algaworks.algafood.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
public class Problem {

	@ApiModelProperty(example="400")
	private Integer status;
	
	@ApiModelProperty(example="2023-22-07T16:26:00.00000Z")
	private OffsetDateTime timestamp;
	
	@ApiModelProperty(example="http://algafood.com.br/dados-invalidos")
	private String type;
	
	@ApiModelProperty(example="Dados inválidos")
	private String title;
	
	@ApiModelProperty(example="Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente")
	private String detail;
	
	@ApiModelProperty(example="Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente")
	private String userMessage;
	
	@ApiModelProperty("Lista de objetos ou campos que geraram o erro (opcional")
	private List<Object> objects;
	
	@Getter
	@Builder
	@ApiModel("ObjetoProblema")
	public static class Object {
		
		@ApiModelProperty(example = "preco")
		private String name;
		
		@ApiModelProperty(example = "O preco é obrigatório")
		private String userMessage;
		
	}
	
}
