package br.edu.fesa.yLib.dao;

import br.edu.fesa.yLib.exception.PersistenciaException;
import java.io.Serializable;
import java.util.List;

/**
 * @author Grupo7
 */
public interface GenericoDAO<E> extends Serializable {

  List<E> listar() throws PersistenciaException;

  void inserir(E e) throws PersistenciaException;

  void alterar(E e) throws PersistenciaException;

  void remover(E e) throws PersistenciaException;

  E listarPorID(E e) throws PersistenciaException;
}
