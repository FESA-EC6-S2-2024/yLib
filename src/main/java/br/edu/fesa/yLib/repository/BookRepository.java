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
public interface BookRepository extends JpaRepository<Book, UUID>, JpaSpecificationExecutor<Book> {
  Optional<Book> findById(UUID id);

  List<Book> findByAvailableUnitsGreaterThan(int units);
}
