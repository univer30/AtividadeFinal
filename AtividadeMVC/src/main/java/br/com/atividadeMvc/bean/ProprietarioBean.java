package br.com.atividadeMvc.bean;



import java.io.Serializable;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.atividadeMvc.DAO.ProprietarioDAO;
import br.com.atividadeMvc.domain.Proprietario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean(name = "proprietarioBean")

public class ProprietarioBean implements Serializable {
	
   private Proprietario proprietario;
   
   private ArrayList<Proprietario> prorietariolist;
   

   public Proprietario getProprietario() {
	  return proprietario;
   }

   public void setProprietario(Proprietario proprietario) {
     	this.proprietario = proprietario;
   }

   
   
   public ArrayList<Proprietario> getProrietariolist() {
	return prorietariolist;
}

 public void setProrietariolist(ArrayList<Proprietario> prorietariolist) {
	this.prorietariolist = prorietariolist;
}

 @PostConstruct
public void listar() {
	   try {
		   ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		   prorietariolist = proprietarioDAO.listar();
		
	} catch (RuntimeException ex) {
		Messages.addGlobalError("Erro ao listar!");
		ex.printStackTrace();
	}
	   
	   
   }
   
   
   public void novo() {
	  proprietario = new Proprietario();
   }
   
   public void salvar() {
	   try {
		   ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		    proprietarioDAO.salvar(proprietario);
			prorietariolist = proprietarioDAO.listar();
			Messages.addGlobalInfo("Salvo com sucesso!");
	} catch (RuntimeException ex) {
		Messages.addGlobalError("Erro em Salvar!");
		  ex.printStackTrace();
	}
   }
   
   public void excluir(ActionEvent evento ) {
		
		try {
			proprietario = (Proprietario) evento.getComponent().getAttributes().get("proprietarioSelecionado");
			ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			proprietarioDAO.excluir(proprietario);
			prorietariolist = proprietarioDAO.listar();
			Messages.addGlobalInfo("Excluido com sucesso!");
			
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro em excluir!");
			ex.printStackTrace();
			// TODO: handle exception
		}
		
	}
   
     public void editar(ActionEvent event) {
	   try {
		   proprietario = (Proprietario) event.getComponent().getAttributes().get("proprietarioSelecionado");
		   ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		   proprietarioDAO.editar(proprietario);
		   Messages.addGlobalInfo("Alterado com sucesso!");
		
	 } catch (RuntimeException ex) {
		 Messages.addGlobalError("Erro ao alterar!");
		  ex.printStackTrace();
	}
	   
	   
   }

}
