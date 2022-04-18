package br.com.thiagoweb.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.xdevapi.Result;

import br.com.thiagoweb.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}
	
	
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
			System.out.println("Salvo com sucesso!");
			
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
			
		}finally {
			sessao.close();
		}
	
	}
	
	
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade resultado = null;
		
		try {
		    resultado = sessao.find(classe, codigo);
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction resultado = null;
		try {
			resultado = sessao.beginTransaction();
			sessao.delete(entidade);
			resultado.commit();
		} catch (RuntimeException erro) {
			if (resultado != null) {
				resultado.rollback();
			}
			throw erro;
		}finally {
			sessao.clear();
		}
		
	}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction resultado = null;
		try {
			resultado = sessao.beginTransaction();
			sessao.update(entidade);	
		} catch (RuntimeException erro) {
			if (resultado != null) {
				resultado.rollback();
			}
			throw erro;
	   }finally {
		sessao.close();
		
	   }
	
	}
	
	public ArrayList<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<Entidade> consulta = builder.createQuery(classe);
			consulta.from(classe);
			ArrayList<Entidade> resultado = (ArrayList<Entidade>) sessao.createQuery(consulta).getResultList();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	

}
