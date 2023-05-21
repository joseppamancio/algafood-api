package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, String taxaFreteInicial, String taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
}