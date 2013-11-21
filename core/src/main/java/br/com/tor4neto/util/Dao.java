package br.com.tor4neto.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DAO genérico com os métodos necessários para as implementações dos serviços do sistema
 * 
 * @author alan.lohse, felipe.almeida, ivaldo.oliveira - Equipe DATASUS
 * 
 * @param <T>
 *            Classe da entidade
 */
public interface Dao<T> extends Serializable {

	/**
	 * Apagar um objeto do banco.
	 * 
	 * @param obj
	 *            o objeto
	 */
	void delete(Serializable id);

	/**
	 * Pesquisar por uma hql query, os parâmetros são opcionais.
	 * 
	 * @param queryStr
	 * @param params
	 * @return
	 */
	List<?> find(String queryStr, Object... params);

	/**
	 * Pesquisar por uma hql query, os parâmetros e a paginação são opcionais.
	 * 
	 * @param queryStr
	 * @param paginacao
	 * @param params
	 * @return
	 */
	List<?> find(String queryStr, Paginacao paginacao, Object... params);

	/**
	 * Recuperar todos os registros de uma entidade.
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * Recuperar todos os registros de uma entidade com paginação.
	 * 
	 * @param paginacao
	 * @return
	 */
	List<T> findAll(Paginacao paginacao);

	/**
	 * Recuperar um objeto pelo seu identificador.
	 * 
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	/**
	 * Pesquisar utilizando uma named query contendo parâmetros nomeados.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryname
	 *            nome da query
	 * @return lista com os objetos encontrados
	 */
	List<T> findByNamedParams(String queryname, Map<String, Object> params);

	/**
	 * Pesquisar utilizando uma named query contendo parâmetros nomeados com opção de paginação.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryname
	 *            nome da query
	 * @return lista com os objetos encontrados
	 */
	List<T> findByNamedParams(String queryname, Paginacao paginacao, Map<String, Object> params);

	/**
	 * Pesquisar utilizando uma named query contendo parâmetros sem nome.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryname
	 *            nome da query
	 * @return lista com os objetos encontrados
	 */
	List<T> findByNamedQuery(String namedQuery, Object... params);

	/**
	 * Pesquisar utilizando uma named query contendo parâmetros sem nome com opção de paginação.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryname
	 *            nome da query
	 * @return lista com os objetos encontrados
	 */
	List<T> findByNamedQuery(String namedQuery, Paginacao paginacao, Object... params);

	/**
	 * Pesquisar utilizando uma query SQL contendo parâmetros sem nome.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryStr
	 *            a query SQL
	 * @return lista com os objetos encontrados
	 */
	List<T> findByNativeQuery(String sql, Object... params);

	/**
	 * Pesquisar utilizando uma query SQL contendo parâmetros sem nome com opção de paginação.
	 * 
	 * @param params
	 *            os parametros da query
	 * @param queryStr
	 *            a query SQL
	 * @return lista com os objetos encontrados.
	 */
	List<T> findByNativeQuery(String sql, Paginacao paginacao, Object... params);

	/**
	 * Pesquisar por uma hql query, os parâmetros e a paginação são opcionais e retorna um resultado único.
	 * 
	 * @param queryStr
	 * @param params
	 * @return
	 */
	Object findSingleResult(String queryStr, Object... params);

	/**
	 * Pesquisar por uma hql query, os parâmetros e a paginação são opcionais e retorna um resultado único.
	 * 
	 * @param queryStr
	 * @param paginacao
	 * @param params
	 * @return
	 */
	Object findSingleResult(String queryStr, Paginacao paginacao, Object... params);

	/**
	 * Atualiza o objeto de acordo com as informações do banco de dados.
	 * 
	 * @param entity
	 */
	void refresh(T entity);

	/**
	 * Cria o objeto no banco.
	 * 
	 * @param obj
	 *            o objeto
	 */
	void save(T obj);

	/**
	 * É obrigatório implementar o método para atribuir o tipo da classe persistente.
	 * 
	 * @param persistentClass
	 */
	void setPersistentClass(Class<T> persistentClass);

	/**
	 * Se o objeto existir, atualiza o objeto no banco. Se não existir cria-se o objeto no banco.
	 * 
	 * @param obj
	 *            o objeto
	 */
	void update(T obj);

}
