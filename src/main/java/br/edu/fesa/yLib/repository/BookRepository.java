package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
  Optional<Book> findById(int id);
  List<Book> findByAvailableUnitsGreaterThan(int units);

  int countBy();

  int countByAvailableUnitsGreaterThan(int units);

  int countByAvailableUnitsEquals(int units);
}
