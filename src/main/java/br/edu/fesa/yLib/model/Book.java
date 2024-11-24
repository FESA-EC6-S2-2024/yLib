package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_BOOKS", schema = "LIBRARY")
public class Book implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_BOOK")
  private int id;

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

  public Book() {
  }

  public Book(
      String ISBN,
      String title,
      Genre genre,
      Date publishedYear,
      int availableUnits,
      int totalUnits,
      Author author,
      Editor editor,
      String image) {
    this.ISBN = ISBN;
    this.title = title;
    this.genre = genre;
    this.publishedYear = publishedYear;
    this.availableUnits = availableUnits;
    this.totalUnits = totalUnits;
    this.author = author;
    this.editor = editor;
    this.image = image; // Adicionando o novo atributo
  }

  public Book(
      int id,
      String ISBN,
      String title,
      Genre genre,
      Date publishedYear,
      int availableUnits,
      int totalUnits,
      Author author,
      Editor editor,
      String image) {
    this.id = id;
    this.ISBN = ISBN;
    this.title = title;
    this.genre = genre;
    this.publishedYear = publishedYear;
    this.availableUnits = availableUnits;
    this.totalUnits = totalUnits;
    this.author = author;
    this.editor = editor;
    this.image = image; // Adicionando o novo atributo
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public Date getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(Date publishedYear) {
    this.publishedYear = publishedYear;
  }

  public int getAvailableUnits() {
    return availableUnits;
  }

  public void setAvailableUnits(int availableUnits) {
    this.availableUnits = availableUnits;
  }

  public int getTotalUnits() {
    return totalUnits;
  }

  public void setTotalUnits(int totalUnits) {
    this.totalUnits = totalUnits;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Editor getEditor() {
    return editor;
  }

  public void setEditor(Editor editor) {
    this.editor = editor;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }
}
