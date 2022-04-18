import java.util.ArrayList;

import br.com.thiagoweb.DAO.ProprietarioDAO;

import br.com.thiagoweb.domain.Proprietario;


public class ProprietarioDAOTest {
	
	public void  salvar() {
		
		ProprietarioDAO proprietarioDao = new ProprietarioDAO();
		Proprietario proprietario = new Proprietario();
		
		proprietario.setNome("Thiago");
		proprietario.setTelefone("1099687-0440");
		proprietario.setIdade("37");
		proprietario.setEndereco("Rua: Leonel Benevides de Resende");
		
		proprietarioDao.salvar(proprietario);
		
	}
	
	public void listar() {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		ArrayList<Proprietario> resultado = proprietarioDAO.listar();
		System.out.println("Total de registros encontrados: " + resultado.size());
		
		for(Proprietario proprietario : resultado) {
			System.out.println("Total de registros encontrados: " + proprietario.getNome());
			System.out.println("Total de registros encontrados: " + proprietario.getIdade());
			System.out.println("Total de registros encontrados: " + proprietario.getTelefone());
			System.out.println("Total de registros encontrados: " + proprietario.getEndereco());
		}
	}

}
