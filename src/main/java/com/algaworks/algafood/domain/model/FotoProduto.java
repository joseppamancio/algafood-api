//package com.algaworks.algafood.domain.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//@Data
//@Entity
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//public class FotoProduto {
//
//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(nullable = false)
//	private String nomeArquivo;
//	
//	@Column(nullable = false)
//	private String descricao;
//	
//	@Column(nullable = false)
//	private String contentType;
//	
//	@Column(nullable = false)
//	private Long tamanho;
//	
//	@OneToMany(mappedBy = "produto")
//	private Produto produto;
//}
