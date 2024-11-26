package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.LoanStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_LOANS", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(name = "ID_LOAN", columnDefinition = "UUID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "STATUS", nullable = false)
  @Builder.Default
  private LoanStatus status = LoanStatus.BORROWED;

  @Column(name = "DUE_DATE", nullable = false)
  @Future(message = "Due date must be in the future")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Builder.Default
  private LocalDate dueDate = LocalDateTime.now().toLocalDate().plusDays(7);

  @Column(name = "RETURN_DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate returnDate;

  @Column(name = "LOAN_DATE", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Builder.Default
  private LocalDate loanDate = LocalDateTime.now().toLocalDate();

  @NotNull(message = "User is required")
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  private User user;

  @NotNull(message = "Book is required")
  @ManyToOne(optional = false, cascade = CascadeType.MERGE)
  @JoinColumn(name = "ID_BOOK", referencedColumnName = "ID_BOOK")
  private Book book;

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
}
