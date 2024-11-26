package br.edu.fesa.yLib.repository;

import br.edu.fesa.yLib.dto.GenreLoansQueryResult;
import br.edu.fesa.yLib.dto.MonthLoanCountQueryResult;
import br.edu.fesa.yLib.enumerator.LoanStatus;
import br.edu.fesa.yLib.model.Loan;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Grupo_7
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
  List<Loan> findByUserId(UUID userId);

  int countBy();

  int countByStatus(LoanStatus status);

  @Query(
      "SELECT EXTRACT(MONTH FROM l.loanDate) loanMonth, COUNT(l) totalLoans "
          + "FROM Loan l "
          + "WHERE EXTRACT(YEAR FROM l.loanDate) = EXTRACT(YEAR FROM CURRENT_TIMESTAMP) "
          + "GROUP BY EXTRACT(MONTH FROM l.loanDate)")
  List<MonthLoanCountQueryResult> countLoansByMonthCurrentYear();

  @Query(
      "SELECT g.description as genre, COUNT(l) as totalLoans "
          + "FROM Loan l "
          + "JOIN Book b ON l.book.id = b.id "
          + "JOIN Genre g ON b.genre.id = g.id "
          + "GROUP BY g.description "
          + "ORDER BY totalLoans DESC")
  List<GenreLoansQueryResult> countByBookGenre();
}
