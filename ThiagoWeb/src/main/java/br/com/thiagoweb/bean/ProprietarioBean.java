package br.com.thiagoweb.bean;

import java.io.Serializable;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.thiagoweb.DAO.ProprietarioDAO;
import br.com.thiagoweb.domain.Proprietario;

@ViewScoped
@ManagedBean(name = "proprietarioBean")

public class ProprietarioBean implements Serializable {
	
	private Proprietario proprietario;
	
	private ArrayList<Proprietario> proprietarios;

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public ArrayList<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(ArrayList<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}
	
	public void novo() {
		proprietario = new Proprietario();
	}
	
	@PostConstruct
	public void listar() {
		try {
			ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			proprietarios = proprietarioDAO.listar();
			
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar");
			ex.printStackTrace();
		}
	}
	
	
	public void salvar(){
		try {
			ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			proprietarioDAO.salvar(proprietario);
			Messages.addGlobalInfo("Salvo com sucesso!");
			proprietarios = proprietarioDAO.listar();
				
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Salvar");
			ex.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			proprietario = (Proprietario) evento.getComponent().getAttributes().get("proprietarioSelecionado");
			ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			proprietarioDAO.excluir(proprietario);
			proprietarios = proprietarioDAO.listar();
			Messages.addGlobalInfo(" Excluido com sucesso!");	
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Excluír");
			ex.printStackTrace();
		}
		
	
	}
	
	public void editar(ActionEvent evento) {
		try {
			proprietario = (Proprietario) evento.getComponent().getAttributes().get("proprietarioSelecionado");	
			
		}catch(RuntimeException ex) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar");
			ex.printStackTrace();
			
		}
		
	}
}
