
import br.com.thiagoweb.DAO.CarroDAO;
import br.com.thiagoweb.DAO.ProprietarioDAO;
import br.com.thiagoweb.domain.Carro;
import br.com.thiagoweb.domain.Proprietario;

public class CarroDAOTest {

public void  salvar() {
		
	ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		CarroDAO carroDAO = new CarroDAO();
		Carro carro = new Carro();
		Proprietario proprietario = proprietarioDAO.buscar(22l);
		carro.setModelo("Palio");
		carro.setMarca("Fiat");
		carro.setTipo("Passageiro");
		carro.setAno("97");
		carro.setProprietario(proprietario);
		carroDAO.salvar(carro);
			
		
	}
}
