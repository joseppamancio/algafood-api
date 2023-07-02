package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{
	List<FormaPagamento> findListByDescricaoContaining(String descricao);
	Optional<FormaPagamento> findByDescricao(String descricao);
	boolean existsByDescricao(String descricao);

}
