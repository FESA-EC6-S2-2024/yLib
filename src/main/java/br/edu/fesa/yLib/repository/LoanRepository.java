package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Loan;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
  List<Loan> findByUserId(UUID userId);
}
