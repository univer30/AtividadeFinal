package br.com.atividadeMvc.bean;

import java.io.Serializable;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.atividadeMvc.DAO.CarroDAO;
import br.com.atividadeMvc.domain.Carro;
import br.com.atividadeMvc.domain.Proprietario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean(name = "CarroBean")
public class CarroBean implements Serializable {
	
	private Carro carro;
	
	private ArrayList<Carro> carros;

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
	
	
	public void novo() {
		carro = new Carro();
	}
	
	
	 @PostConstruct
	public void listar() {
		try {
			CarroDAO carroDAO = new CarroDAO();
			carros = carroDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao listar!");
			ex.printStackTrace();
			
		}
		
	}
	 
	 public void excluir(ActionEvent evento) {
		 try {
			    carro = (Carro) evento.getComponent().getAttributes().get("carroSelecionado");
				CarroDAO carroDAO = new CarroDAO();
				carroDAO.excluir(carro);
				Messages.addGlobalInfo("Excluido com sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro em excluir!");
			ex.printStackTrace();
			// TODO: handle exception
		}
		
	 }
	 
     public void editar(ActionEvent evento) {
    	 try {
    		    carro = (Carro) evento.getComponent().getAttributes().get("carroSelecionado");
				CarroDAO carroDAO = new CarroDAO();
				carroDAO.excluir(carro);
				carros = carroDAO.listar();
				Messages.addGlobalInfo("Editado com sucesso!");
			
		} catch (RuntimeException ex) {
			 
	     	Messages.addGlobalError("Erro em Alterar!");
			ex.printStackTrace();
		
		}
		 
	 }
     
     public void salvar() {
    	 try {
    		 
    		 CarroDAO carroDAO = new CarroDAO();
    		 carroDAO.salvar(carro);
    		 carros = carroDAO.listar();
    		 Messages.addGlobalInfo("Salvo com sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro em Salvar!");
			ex.printStackTrace();
			
		}
     }


}
