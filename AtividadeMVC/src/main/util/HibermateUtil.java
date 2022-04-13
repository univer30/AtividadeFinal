package br.com.atividadeMvc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibermateUtil {
	
	private static SessionFactory criarSessoes = criarSessoes();
	
	public SessionFactory getSessoes() {
		return criarSessoes;
	}
	
	public static SessionFactory criarSessoes() {
		try {
			 Configuration configuracao = new Configuration().configure("hibernate.cfg.xml");
			 SessionFactory criacao = configuracao.buildSessionFactory();
			   return criacao;
			
		} catch (Throwable ex) {
		
			System.out.println("A crição de sessões não pode ser criada!");
			   throw new ExceptionInInitializerError(ex);
		}
	}

}
