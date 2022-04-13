package br.com.atividadeMvc.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro extends GenericDomain {
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Proprietario proprietario;
	
	@Column( length = 50,nullable=false)
	private String marca;
	
	@Column( length = 50,nullable=false)
	private String modelo;
	
	
	@Column( length = 3 ,nullable = false)
	private int ano;
	
	@Column( length = 30, nullable = false)
	private String tipo;
	

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	

}
