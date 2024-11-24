package br.edu.fesa.yLib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_NOTIFICATIONS", schema = "LIBRARY")
public class Notification implements Serializable {

  private static final long serialVersionUID = 2L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ou outra estratégia adequada
  @Column(name = "ID_NOTIFICATION")
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_LOAN", referencedColumnName = "ID_LOAN")
  private Loan loan;

  @Column(name = "NOTIFICATION_DATE", nullable = false)
  private LocalDateTime date;

  public Notification() {}

  public Notification(Loan loan, LocalDateTime date) {
    this.loan = loan;
    this.date = date;
  }

  // Getters e Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Loan getLoan() {
    return loan;
  }

  public void setLoan(Loan loan) {
    this.loan = loan;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
