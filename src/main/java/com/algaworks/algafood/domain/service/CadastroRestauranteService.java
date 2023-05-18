package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		if (cozinhaRepository.buscar(cozinhaId) == null)
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o código %d.", cozinhaId));
		return restauranteRepository.salvar(restaurante);
	}

	public void excluir(Long restaurantId) {
		try {
			restauranteRepository.remover(restaurantId);
		}catch (EmptyResultDataAccessException e) { 
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de restaurante com o código %d.", restaurantId));	
		}catch (DataIntegrityViolationException e) { 
			throw new EntidadeEmUsoException(
					String.format("Restaurante de código %d não pode ser removida, pois está em uso", restaurantId));
		}
	}

}
