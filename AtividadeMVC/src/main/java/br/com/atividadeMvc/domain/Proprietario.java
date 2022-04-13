package br.com.atividadeMvc.domain;

import javax.persistence.Column;

import javax.persistence.Entity;

@Entity
public class Proprietario extends GenericDomain {
	
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length =100, nullable = false)
	private String telefone;
	
	@Column(length = 100, nullable = false)
	private String enereco;
	
	@Column(length = 20, nullable = false)
	private int idade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEnereco() {
		return enereco;
	}
	public void setEnereco(String enereco) {
		this.enereco = enereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
