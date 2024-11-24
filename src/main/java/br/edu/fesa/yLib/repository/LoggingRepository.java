package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Logging;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface LoggingRepository extends JpaRepository<Logging, UUID> {
  Optional<Logging> findById(UUID id);
}
