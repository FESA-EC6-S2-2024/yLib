package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.fesa.yLib.enumerator.LoanStatus;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_LOANS", schema = "LIBRARY")
public class Loan implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_LOAN")
  private int id;

  @Column(name = "STATUS", nullable = false)
  private LoanStatus status;

  @Column(name = "DUE_DATE", nullable = false)
  @Future(message = "Due date must be in the future")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueDate;

  @Column(name = "RETURN_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate returnDate;

  @Column(name = "LOAN_DATE", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate loanDate;

  @NotNull(message = "User is required")
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  private User user;

  @NotNull(message = "Book is required")
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "ID_BOOK", referencedColumnName = "ID_BOOK")
  private Book book;

  public Loan() {
    this.loanDate = LocalDateTime.now().toLocalDate();
    this.dueDate = this.loanDate.plusDays(7);
    this.status = LoanStatus.BORROWED;
  }

  public Loan(
      int id,
      LoanStatus status,
      LocalDate dueDate,
      LocalDate returnDate,
      LocalDate loanDate,
      User user,
      Book books) {
    this.id = id;
    this.status = status;
    this.dueDate = dueDate;
    this.returnDate = returnDate;
    this.loanDate = loanDate;
    this.user = user;
    this.book = books;
  }

  public void completeLoan() {
    this.status = LoanStatus.RETURNED;
    this.returnDate = LocalDate.now();
  }

  public void undoLoan() {
    this.status = LoanStatus.BORROWED;
    this.returnDate = null;
  }

  public void cancelLoan() {
    this.status = LoanStatus.CANCELED;
    this.returnDate = null;
  }  
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LoanStatus getStatus() {
    return status;
  }

  public void setStatus(LoanStatus status) {
    this.status = status;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public LocalDate getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(LocalDate loanDate) {
    this.loanDate = loanDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}
