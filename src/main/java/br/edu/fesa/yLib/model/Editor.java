package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;
import lombok.*;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_EDITORS", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Editor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_EDITOR", columnDefinition = "UUID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "NAME", nullable = false, length = 100)
  @NotEmpty(message = "Name can not be empty")
  private String name;
}
