import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.atividadeMvc.bean.CarroBean;
import br.com.atividadeMvc.bean.ProprietarioBean;

public class Principal {
	

	public static void main(String[] args) {
		//ProprietarioDAOTeste p = new  ProprietarioDAOTeste();
		//p.salvar();
		//p.excluir();
		//p.editar();
		//p.listar();
			
		
		CarroDAOTeste c = new CarroDAOTeste();
		c.salvar();
		//c.editar();
		//c.listar();
		//ProprietarioBean pro = new ProprietarioBean();
		//pro.listar();
		
		//CarroBean carro = new  CarroBean();
		//carro.listar();
		
	}
	
	
	
	
}
