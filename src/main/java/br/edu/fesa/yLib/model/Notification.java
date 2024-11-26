package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_NOTIFICATIONS", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification implements Serializable {

  private static final long serialVersionUID = 2L;

  @Id
  @UuidGenerator
  @Column(name = "ID_NOTIFICATION", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_LOAN", referencedColumnName = "ID_LOAN")
  private Loan loan;

  @Column(name = "NOTIFICATION_DATE", nullable = false)
  private LocalDateTime date;
}
