package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.LogHistory;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface LogHistoryRepository extends JpaRepository<LogHistory, UUID> {
  Optional<LogHistory> findById(UUID id);
}
