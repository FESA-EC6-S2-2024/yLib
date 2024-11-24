package br.edu.fesa.yLib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_BOOK", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_BOOK", columnDefinition = "UUID", updatable = false, nullable = false)
  private UUID id;

  @NotBlank(message = "ISBN is required.")
  @Size(max = 20, message = "ISBN should not exceed 20 characters.")
  @Column(name = "ISBN", nullable = false, length = 20, unique = true)
  private String ISBN;

  @NotBlank(message = "Title is required.")
  @Size(max = 255, message = "Title should not exceed 255 characters.")
  @Column(name = "TITLE", nullable = false, length = 255)
  private String title;

  @NotNull(message = "Genre is required.")
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")
  private Genre genre;

  @NotNull(message = "Published year is required.")
  @Column(name = "PUBLISHED_YEAR", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date publishedYear;

  @Positive(message = "Available units must be positive.")
  @Column(name = "AVAILABLE_UNITS", nullable = false)
  private int availableUnits;

  @Positive(message = "Total units must be positive.")
  @Column(name = "TOTAL_UNITS", nullable = false)
  private int totalUnits;

  @NotNull(message = "Author is required.")
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_AUTHOR", referencedColumnName = "ID_AUTHOR")
  private Author author;

  @NotNull(message = "Editor is required.")
  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_EDITOR", referencedColumnName = "ID_EDITOR")
  private Editor editor;

  @Column(name = "IMAGE")
  private String image;

  @Column(name = "SYNOPSIS", length = 2000)
  @Length(max = 2000, message = "Synopsis can not exceed 2000 characters")
  private String synopsis;
}
