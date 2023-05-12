package com.algaworks.algafood.di.modelo;

import java.util.Objects;

public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private boolean ativo = false;
	
	public Cliente(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	public void ativar() {
		this.ativo = true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", ativo=" + ativo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, email, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return ativo == other.ativo && Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	
}
