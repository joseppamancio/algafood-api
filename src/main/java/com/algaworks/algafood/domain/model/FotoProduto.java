package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FotoProduto {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "produto_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomeArquivo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String contentType;
	
	@Column(nullable = false)
	private Long tamanho;
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	
	public Long getRestauranteId() {
		if(getProduto() != null) {
			return getProduto().getRestaurante().getId();
		}
		return null;
	}
}
