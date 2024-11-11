package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Editor;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {
}
