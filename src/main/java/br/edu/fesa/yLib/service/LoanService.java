package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.dto.GenreLoansQueryResult;
import br.edu.fesa.yLib.dto.LoanCountByGenreDto;
import br.edu.fesa.yLib.dto.LoanCountByMonthDto;
import br.edu.fesa.yLib.dto.MonthLoanCountQueryResult;
import br.edu.fesa.yLib.enumerator.LoanStatus;
import br.edu.fesa.yLib.exception.BookNotAvailableException;
import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.repository.BookRepository;
import br.edu.fesa.yLib.repository.LoanRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo_7
 */
@Service
public class LoanService {

  @Autowired private LoanRepository loanRepository;

  @Autowired private BookRepository bookRepository;

  public List<Loan> findAll() {
    return loanRepository.findAll();
  }

  public List<Loan> findAllByUserId(UUID userId) {
    return loanRepository.findByUserId(userId);
  }

  @Transactional
  public Loan createLoan(@Valid Loan loan) throws BookNotAvailableException {
    Book book = loan.getBook();

    if (!book.isAvailable()) {
      throw new BookNotAvailableException();
    }

    book.borrowBook();
    bookRepository.save(book);

    return loanRepository.save(loan);
  }

  @Transactional
  public Loan completeLoan(UUID loanId) {
    Loan loan = loanRepository.findById(loanId).get();

    Book book = loan.getBook();
    book.returnBook();
    bookRepository.save(book);

    loan.completeLoan();
    return loanRepository.save(loan);
  }

  @Transactional
  public Loan undoLoan(UUID loanId) {
    Loan loan = loanRepository.findById(loanId).get();

    Book book = loan.getBook();
    book.undoBorrowBook();
    bookRepository.save(book);

    loan.undoLoan();
    return loanRepository.save(loan);
  }

  @Transactional
  public Loan cancelLoan(UUID loanId) {
    Loan loan = loanRepository.findById(loanId).get();

    Book book = loan.getBook();
    book.returnBook();
    bookRepository.save(book);

    loan.cancelLoan();
    return loanRepository.save(loan);
  }

  public int countLoans() {
    return loanRepository.countBy();
  }

  public int countActiveLoans() {
    return loanRepository.countByStatus(LoanStatus.BORROWED);
  }

  public LoanCountByMonthDto countLoansInCurrentYearByMonth() {
    List<MonthLoanCountQueryResult> res = loanRepository.countLoansByMonthCurrentYear();
    LoanCountByMonthDto dto = new LoanCountByMonthDto();

    for (MonthLoanCountQueryResult item : res) {
      dto.addMonth(item.getLoanMonth());
      dto.addCount(item.getTotalLoans());
    }

    return dto;
  }

  public LoanCountByGenreDto countLoansByGenre() {
    List<GenreLoansQueryResult> res = loanRepository.countByBookGenre();
    LoanCountByGenreDto dto = new LoanCountByGenreDto();

    for (GenreLoansQueryResult genreLoansQueryResult : res) {
      dto.addGenre(genreLoansQueryResult.getGenre());
      dto.addCount(genreLoansQueryResult.getTotalLoans());
    }

    return dto;
  }
}
