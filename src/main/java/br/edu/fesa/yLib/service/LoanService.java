package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.exception.BookNotAvailableException;
import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.repository.BookRepository;
import br.edu.fesa.yLib.repository.LoanRepository;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo7
 */
@Service
public class LoanService {

  @Autowired private LoanRepository loanRepository;

  @Autowired
  private BookRepository bookRepository;

  public List<Loan> findAll() {
    return loanRepository.findAll();
  }

  public List<Loan> findAllByUserId(int userId) {
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
  public Loan canceLoan(UUID loanId) {
    Loan loan = loanRepository.findById(loanId).get();
    
    Book book = loan.getBook();
    book.returnBook();
    bookRepository.save(book);

    loan.cancelLoan();
    return loanRepository.save(loan);
  }
}
