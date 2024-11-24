package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.LogType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_LOG_HISTORY", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logging implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_LOG", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "MESSAGE", columnDefinition = "CLOB", nullable = false)
  private String message;

  @Column(name = "LOG_DATE", nullable = false)
  private LocalDateTime logDate;

  @ManyToOne(optional = true)
  @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
  private User user;

  @Enumerated(EnumType.STRING)
  @Column(name = "LOG_TYPE", nullable = false)
  private LogType logType;
}
