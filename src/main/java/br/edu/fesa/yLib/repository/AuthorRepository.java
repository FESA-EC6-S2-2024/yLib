package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Author;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {}
