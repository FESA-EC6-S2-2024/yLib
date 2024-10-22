package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Author;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    // Método para buscar um padrão pelo nome
    Optional<Author> findByNome(String nome);
}
