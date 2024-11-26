package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);

  boolean existsByEmailAndIdNot(String email, UUID id);

  int countBy();
}
