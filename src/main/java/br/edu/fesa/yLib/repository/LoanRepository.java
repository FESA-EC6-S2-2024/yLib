package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.model.Loan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
  List<Loan> findByUserId(int userId);
}
