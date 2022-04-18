package br.com.thiagoweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory fabricadeSessao = criarSessao();
	
	public static SessionFactory getFabricaDeSessoes() {
		return fabricadeSessao;
	}


	private static SessionFactory criarSessao() {
		 try {
			 
			 Configuration configuracao = new Configuration().configure("hibernate.cfg.xml");
			 SessionFactory fabrica = configuracao.buildSessionFactory();
			 return fabrica;
			 
					 
		} catch (Throwable ex) {
			System.err.println("A fabrica de sessões não pode ser criada " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
