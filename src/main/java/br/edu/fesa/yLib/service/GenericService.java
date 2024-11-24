package br.edu.fesa.yLib.service;

import java.util.List;

/**
 * @author Grupo 7
 */
public interface GenericService<T, ID> {

  List<T> findAll();

  T findById(ID id);

  T save(T entity);

  void update(ID id, T entity);

  void delete(ID id);
}
