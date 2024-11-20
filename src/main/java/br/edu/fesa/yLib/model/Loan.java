package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_LOAN", schema = "LIBRARY")
public class Loan implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_LOAN")
  private int id;

  @Column(name = "DUE_DATE", nullable = false)
  private LocalDateTime dueDate;

  @Column(name = "RETURN_DATE")
  private LocalDateTime returnDate;

  @Column(name = "LOAN_DATE", nullable = false)
  private LocalDateTime loanDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  private User user;

  // Many-to-many relationship with Book (one loan can have multiple books)
  @ManyToMany
  @JoinTable(name = "TB_LOAN_BOOK", joinColumns = @JoinColumn(name = "ID_LOAN"), inverseJoinColumns = @JoinColumn(name = "ID_BOOK"))
  private List<Book> books;

  public Loan() {
  }

  public Loan(LocalDateTime dueDate, LocalDateTime loanDate, User user, List<Book> books) {
    this.dueDate = dueDate;
    this.loanDate = loanDate;
    this.user = user;
    this.books = books;
  }

  public Loan(
      int id,
      LocalDateTime dueDate,
      LocalDateTime returnDate,
      LocalDateTime loanDate,
      User user,
      List<Book> books) {
    this.id = id;
    this.dueDate = dueDate;
    this.returnDate = returnDate;
    this.loanDate = loanDate;
    this.user = user;
    this.books = books;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public LocalDateTime getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDateTime returnDate) {
    this.returnDate = returnDate;
  }

  public LocalDateTime getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(LocalDateTime loanDate) {
    this.loanDate = loanDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
