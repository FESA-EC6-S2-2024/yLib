package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;

/**
 * @author Grupo7
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
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_LOAN", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "DUE_DATE", nullable = false)
  private LocalDateTime dueDate;

  @Column(name = "RETURN_DATE")
  private LocalDateTime returnDate;

  @Column(name = "LOAN_DATE", nullable = false)
  private LocalDateTime loanDate;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  private User user;

  @ManyToMany
  @JoinTable(
      name = "TB_LOAN_BOOK",
      joinColumns = @JoinColumn(name = "ID_LOAN"),
      inverseJoinColumns = @JoinColumn(name = "ID_BOOK"))
  private List<Book> books;
}
