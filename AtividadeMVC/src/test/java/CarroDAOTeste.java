import java.util.ArrayList;


import br.com.atividadeMvc.DAO.CarroDAO;
import br.com.atividadeMvc.DAO.ProprietarioDAO;
import br.com.atividadeMvc.domain.Carro;
import br.com.atividadeMvc.domain.Proprietario;

public class CarroDAOTeste {
	
     public void salvar() {	
		CarroDAO carroDAO = new CarroDAO();
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        Proprietario proprietario = proprietarioDAO.buscar(1l);
		
        Carro carro = new Carro();
		
		carro.setMarca("Fiat");
		carro.setModelo("Palio");
		carro.setAno(97);
		carro.setTipo("Passeio");
		carro.setProprietario(proprietario);
		
	    carroDAO.salvar(carro);
		
	    System.out.println("Cadastrado com sucesso! \b" + proprietario);
		
	}
     
     public void excluir() {
    	 Long codigo = 8L;
    	 CarroDAO carroDAO = new CarroDAO();
    	 Carro carro = carroDAO.buscar(codigo);
    	 
    	 carroDAO.excluir(carro);
    	 System.out.println("Dedeltado com sucesso!");	 
     }
     
     public void editar() {
    	 Long codigo = 8L;
    	 Long codigoProp = 2L;
    	 CarroDAO carroDAO = new CarroDAO();
    	 ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
    	 Carro carro = carroDAO.buscar(codigo);
    	 Proprietario proprietario = proprietarioDAO.buscar(codigoProp);
    	 
    	 System.out.println("Carro - antes:");
 		 System.out.println("Codigo da Carro: " + carro.getCodigo());
 		 System.out.println("Marca da Carro: " + carro.getMarca());
 		 System.out.println("Modelo da Carro: " + carro.getModelo());
 		 System.out.println("Ano da Carro: " + carro.getAno());
 		 System.out.println("Tipo da Carro: " + carro.getTipo());
 		
 		
    	 carro.setMarca("Ford");
    	 carro.setModelo("Ford Fiest");
    	 carro.setAno(2010);
    	 carro.setTipo("Passeio");
    	 
    	 carroDAO.editar(carro);
    	 
    	 System.out.println("Carro - depois:");
 		 System.out.println("Codigo da Carro: " + carro.getCodigo());
 		 System.out.println("Marca da Carro: " + carro.getMarca());
 		 System.out.println("Modelo da Carro: " + carro.getModelo());
 		 System.out.println("Ano da Carro: " + carro.getAno());
 		 System.out.println("Tipo da Carro: " + carro.getTipo());
    	 	 
     }
     
     public void listar() {
    	 CarroDAO carroDAO = new CarroDAO();
    	 ArrayList<Carro> result = carroDAO.listar();
    	 
    	 for(Carro carro : result) {
    		 
    		System.out.println("Codigo da Carro: " + carro.getCodigo());
 			System.out.println("Modelo da carro: " + carro.getModelo());
 			System.out.println("Marca da carro: " + carro.getMarca());
 			System.out.println("Tipo da carro: " + carro.getTipo());
 			System.out.println("Ano da carro: " + carro.getAno());
 			
    		 
    	 }
     }

}
