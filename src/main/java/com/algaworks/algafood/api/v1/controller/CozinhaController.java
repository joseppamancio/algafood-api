package com.algaworks.algafood.api.v1.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.assembler.CozinhaInputDisassembler;
import com.algaworks.algafood.api.v1.assembler.CozinhaModelAssembler;
import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;
import com.algaworks.algafood.api.v1.openapi.controller.CozinhaControllerOpenApi;
import com.algaworks.algafood.core.security.CheckSecurity;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController implements CozinhaControllerOpenApi {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Autowired
	private CozinhaModelAssembler cozinhaModelAssembler;

	@Autowired
	private CozinhaInputDisassembler cozinhaInputDisassembler;

	@Autowired
	private PagedResourcesAssembler<Cozinha> pagedResourcesAssembler;

	@Override
	@CheckSecurity.Cozinhas.PodeConsultar
	@GetMapping
	public PagedModel<CozinhaModel> listar(@PageableDefault(size = 10) Pageable pageable) {
		
		log.debug("Consultando cozinhas com páginas de {} registros...", pageable.getPageSize());
		
		Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);

		PagedModel<CozinhaModel> cozinhasPagedModel = pagedResourcesAssembler
				.toModel(cozinhasPage, cozinhaModelAssembler);

		return cozinhasPagedModel;
	}

	@Override
	@CheckSecurity.Cozinhas.PodeConsultar
	@GetMapping(value = "/{cozinhaId}")
	public CozinhaModel buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

		return cozinhaModelAssembler.toModel(cozinha);
	}

	@Override
	@CheckSecurity.Cozinhas.PodeEditar
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaModel adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);
		cozinha = cadastroCozinha.salvar(cozinha);
		
		return cozinhaModelAssembler.toModel(cozinha);
	}

	@Override
	@CheckSecurity.Cozinhas.PodeEditar
	@PutMapping(value = "/{cozinhaId}")
	public CozinhaModel atualizar(@PathVariable Long cozinhaId,
	                              @RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);
		cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);

		return cozinhaModelAssembler.toModel(cozinhaAtual);
	}

	@CheckSecurity.Cozinhas.PodeEditar
	@Override
	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> remover(@PathVariable Long cozinhaId) {
		cadastroCozinha.excluir(cozinhaId);
		return ResponseEntity.noContent().build();
	}

}
