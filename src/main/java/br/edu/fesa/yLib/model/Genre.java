package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import lombok.*;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_GENRES", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre implements Serializable {

  private static final long serialVersionUID = 2L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_GENRE", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "DESCRIPTION", nullable = false, length = 256)
  private String description;
}
