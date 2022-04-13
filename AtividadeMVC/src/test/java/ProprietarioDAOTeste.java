import java.util.ArrayList;


import br.com.atividadeMvc.DAO.ProprietarioDAO;

import br.com.atividadeMvc.domain.Proprietario;


public class ProprietarioDAOTeste {


		public void salvar() {
			 ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			 Proprietario proprietario = new Proprietario();
			 
			 proprietario.setNome("Thiago");
			 proprietario.setEnereco("Rua Leonel");
			 proprietario.setIdade(37);
			 proprietario.setTelefone("14 9666666");
			 proprietarioDAO.salvar(proprietario);	
			  
		 }
		
		
		public void excluir() {
			Long codigo = 1L;
			 ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			 
			Proprietario proprietario =  proprietarioDAO.buscar(codigo);
			
			if(proprietario == null) {
				System.out.println("Nenhum registro encontrado!");
			}else {
				System.out.println("Deletado com sucesso!");
				proprietarioDAO.excluir(proprietario);
			}
			 
		}
		
		public void editar() {
			 Long codigo = 2L;
			 ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
			 Proprietario proprietario =  proprietarioDAO.buscar(codigo);
			 if(proprietario == null) {
					System.out.println("Nenhum registro encontrado!");
				}else {
					System.out.println("Dados do proprietario - antes:");
					System.out.println("Codigo da Proprietário: " + proprietario.getCodigo());
					System.out.println("Nome: " + proprietario.getNome());
					System.out.println("Endereço: " + proprietario.getEnereco());
					System.out.println("Idade: " + proprietario.getIdade());
					System.out.println("Nome da estado: " + proprietario.getTelefone());
					
					
					proprietario.setCodigo(codigo);
					proprietario.setNome("Josefa");
					proprietario.setIdade(68);
					proprietario.setEnereco("AV Rio branco");
					proprietario.setTelefone("14966666666");
					proprietarioDAO.editar(proprietario);
					System.out.println("Editado com sucesso!");
					
					System.out.println("Dados do proprietario - depois:");
					System.out.println("Codigo da Proprietário: " + proprietario.getCodigo());
					System.out.println("Nome: " + proprietario.getNome());
					System.out.println("Endereço: " + proprietario.getEnereco());
					System.out.println("Idade: " + proprietario.getIdade());
					System.out.println("Nome da estado: " + proprietario.getTelefone());
			}
			 
		}
		
		 public void listar() {
	    	 ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
	    	 ArrayList<Proprietario> result = proprietarioDAO.listar();
	    	 
	    	 for(Proprietario proprietario : result) {
	    		 
	    		System.out.println("Codigo da proprietario: " + proprietario.getCodigo());
	 			System.out.println("Nome da proprietario: " + proprietario.getNome());
	 			System.out.println("Telefone da proprietario: " + proprietario.getTelefone());
	 			System.out.println("Endereco da proprietario: " + proprietario.getEnereco());
	 			System.out.println("Ano da carro: " + proprietario.getIdade());
	 			
	    		 
	    	 }
	     }

	}


