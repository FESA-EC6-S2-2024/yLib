package br.edu.fesa.yLib.dao;

import br.edu.fesa.yLib.exception.PersistencyException;
import java.io.Serializable;
import java.util.List;

/**
 * @author Grupo_7
 */
public interface GenericoDAO<E> extends Serializable {

  List<E> listar() throws PersistencyException;

  void inserir(E e) throws PersistencyException;

  void alterar(E e) throws PersistencyException;

  void remover(E e) throws PersistencyException;

  E listarPorID(E e) throws PersistencyException;
}
