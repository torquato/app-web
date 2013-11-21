package br.com.tor4neto.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

/**
 * Implementação do DAO genérico com os métodos necessários para as implementações de DAO do sistema. É necessário
 * herdar esta classe JpaDao<T> para implementar um DAO específico.
 * 
 * 
 * @author felipe.almeida, ivaldo.oliveira - Equipe DATASUS
 * 
 * @param <T>
 *            Classe da entidade
 * 
 */
@Repository("dao")
@Scope(proxyMode = ScopedProxyMode.NO, value = "prototype")
public class JpaDao<T> implements Dao<T> {

	private static final long serialVersionUID = 6907111403428623938L;

	private Class<T> persistentClass;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private String databaseRole;

	@Autowired
	private Boolean databaseRoleEnabled;

	private Query createQuery(String queryStr, Paginacao paginacao, Object... params) {
		Query query = this.entityManager.createQuery(queryStr);
		setQueryParams(query, params);
		paginar(paginacao, query);
		return query;
	}

	@Override
	public void delete(Serializable id) {
		this.setRole();
		this.entityManager.remove(findById(id));
	}

	@Override
	public List<?> find(String queryStr, Object... params) {
		return find(queryStr, null, params);
	}

	@Override
	public List<?> find(String queryStr, Paginacao paginacao, Object... params) {
		return createQuery(queryStr, paginacao, params).getResultList();
	}

	@Override
	public List<T> findAll() {
		return findAll(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Paginacao paginacao) {
		Query query = this.entityManager.createQuery(" FROM " + getPersistentClass().getSimpleName());
		paginar(paginacao, query);
		return query.getResultList();
	}

	@Override
	public T findById(Serializable id) {
		return this.entityManager.find(getPersistentClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNamedParams(String queryname, Map<String, Object> params) {
		Query query = this.entityManager.createNamedQuery(queryname);
		setQueryParams(query, params);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParams(String queryname, Paginacao paginacao, Map<String, Object> params) {
		Query query = this.entityManager.createNamedQuery(queryname);
		setQueryParams(query, params);
		paginar(paginacao, query);
		return query.getResultList();
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery, Object... params) {
		return findByNamedQuery(namedQuery, null, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String namedQuery, Paginacao paginacao, Object... params) {
		Query query = this.entityManager.createNamedQuery(namedQuery);
		setQueryParams(query, params);
		paginar(paginacao, query);
		return query.getResultList();
	}

	@Override
	public List<T> findByNativeQuery(String sql, Object... params) {
		return findByNativeQuery(sql, null, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNativeQuery(String sql, Paginacao paginacao, Object... params) {
		Query query = this.entityManager.createNativeQuery(sql);
		setQueryParams(query, params);
		paginar(paginacao, query);
		return query.getResultList();
	}

	public Object findSingleResult(String queryStr, Object... params) {
		return findSingleResult(queryStr, null, params);
	}

	public Object findSingleResult(String queryStr, Paginacao paginacao, Object... params) {
		return createQuery(queryStr, paginacao, params).getSingleResult();
	}

	public final Class<T> getPersistentClass() {
		if (persistentClass == null) {
			throw new RuntimeException("É necessário invocar o método setPersistentClass(Class<T> clazz)");
		}
		return persistentClass;
	}

	/**
	 * Atribuir paginação a query.
	 * 
	 * @param paginacao
	 * @param query
	 */
	private void paginar(Paginacao paginacao, Query query) {
		if (paginacao != null) {
			if (paginacao.getPosicao() != null) {
				query.setFirstResult(paginacao.getPosicao());
			}
			if (paginacao.getLimite() != null) {
				query.setMaxResults(paginacao.getLimite());
			}
		}
	}

	public void refresh(T entity) {
		this.entityManager.refresh(entity);
	}

	@Override
	public void save(T obj) {
		this.setRole();
		this.entityManager.persist(obj);
	}

	public final void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Atribuir os parâmetros nomeados da query.
	 * 
	 * @param query
	 * @param params
	 */
	private void setQueryParams(Query query, Map<String, Object> params) {
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Atribuir os parâmetros da query.
	 * 
	 * @param query
	 * @param params
	 */
	private void setQueryParams(Query query, Object... params) {
		if (params != null && params.length > 0) {
			int i = 0;
			for (Object param : params) {
				if (param != null) {
					if ((param instanceof String && ((String) param).trim().isEmpty())) {
						continue;
					}
					i++;
					query.setParameter(i, param);
				}
			}
		}
	}

	/**
	 * Atribuir a Role para as operações solicitadas pelo usuário.
	 * 
	 */
	private void setRole() {
		if (this.databaseRoleEnabled) {
			this.entityManager.createNativeQuery(databaseRole).executeUpdate();
		}
	}

	@Override
	public void update(T obj) {
		this.setRole();
		this.entityManager.merge(obj);
	}

}
