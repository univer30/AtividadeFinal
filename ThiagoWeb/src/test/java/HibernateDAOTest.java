import java.util.ArrayList;

import org.hibernate.Session;

import br.com.thiagoweb.DAO.ProprietarioDAO;
import br.com.thiagoweb.domain.Proprietario;
import br.com.thiagoweb.util.HibernateUtil;

public class HibernateDAOTest {

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		sessao.close();
		
		HibernateUtil.getFabricaDeSessoes().close();

	}
	
	

}
