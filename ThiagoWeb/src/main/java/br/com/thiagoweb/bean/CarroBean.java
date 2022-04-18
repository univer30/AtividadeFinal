package br.com.thiagoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.thiagoweb.DAO.CarroDAO;
import br.com.thiagoweb.DAO.ProprietarioDAO;
import br.com.thiagoweb.domain.Carro;
import br.com.thiagoweb.domain.Proprietario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean(name = "carroBean")
public class CarroBean implements Serializable {
	
	private Carro carro;
	private ArrayList<Carro> carros;
	private ArrayList<Proprietario> proprietarios;
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	public ArrayList<Proprietario> getProprietarios() {
		return proprietarios;
	}
	public void setProprietarios(ArrayList<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}
	
	@PostConstruct
	public void listar() {
		try {
			
			CarroDAO carroDAO = new CarroDAO();
			carros = carroDAO.listar();
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao listar carros!");
			ex.printStackTrace();
		
		}
		
		
	}
	
	public void novo(){
		try {
			carro =  new Carro();	
			ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			proprietarios = proprietarioDAO.listar();
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao adicionar novor!");
			ex.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			carro = (Carro)evento.getComponent().getAttributes().get("carroSelecionado");
			CarroDAO carroDAO = new CarroDAO();
			carroDAO.excluir(carro);
			carros = carroDAO.listar();
			Messages.addGlobalInfo("Excluido com sucesso!");
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao excluír!");
			ex.printStackTrace();
			
		}
	  }
	
  public void salvar() {
	  try {
		  CarroDAO carroDAO = new CarroDAO();
		  carroDAO.salvar(carro);
		  carros = carroDAO.listar();
		  Messages.addGlobalInfo("Salvar com sucesso!");
	} catch (RuntimeException ex) {
		Messages.addGlobalError("Erro ao Salvar!");
		ex.printStackTrace();
	}
  }
  
  public void editar(ActionEvent evento) {
	  
	  try {
		  carro = (Carro) evento.getComponent().getAttributes().get("carroSelecionada");
		  ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		  proprietarios = proprietarioDAO.listar();
		 
	  }catch (RuntimeException ex) {
		  Messages.addGlobalError("Erro ao editar!");
		  ex.printStackTrace();
	  }
	  
  }
}


	
	
