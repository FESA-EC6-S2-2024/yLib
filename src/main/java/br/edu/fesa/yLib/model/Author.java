package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_AUTHOR", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "ID_AUTHOR", columnDefinition = "UUID", updatable = false, nullable = false)
  private UUID id;

  @NotBlank(message = "Name is required.")
  @Size(max = 100, message = "Name must be at most 100 characters.")
  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @NotBlank(message = "Country is required.")
  @Size(max = 50, message = "Country must be at most 50 characters.")
  @Column(name = "COUNTRY", nullable = false, length = 50)
  private String country;

  @NotNull(message = "Birth date is required.")
  @Past(message = "Birth date must be in the past.")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "BIRTH_DATE", nullable = false)
  private Date birthDate;
}
