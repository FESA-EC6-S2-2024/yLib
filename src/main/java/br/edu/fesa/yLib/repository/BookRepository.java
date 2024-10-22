package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Book;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    // Método para buscar um padrão pelo nome
    Optional<Book> findByNome(String nome);
}
