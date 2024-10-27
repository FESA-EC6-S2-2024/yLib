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
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_BOOK", schema = "LIBRARY")
public class Book implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_BOOK")
  private int id;

  @Column(name = "ISBN", nullable = false, length = 20, unique = true)
  private String ISBN;

  @Column(name = "TITLE", nullable = false, length = 255)
  private String title;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")
  private Genre genre;

  @Column(name = "PUBLISHED_YEAR", nullable = false)
  private LocalDateTime publishedYear;

  @Column(name = "AVAILABLE_UNITS", nullable = false)
  private int availableUnits;

  @Column(name = "TOTAL_UNITS", nullable = false)
  private int totalUnits;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_AUTHOR", referencedColumnName = "ID_AUTHOR")
  private Author author;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ID_EDITOR", referencedColumnName = "ID_EDITOR")
  private Editor editor;

  public Book() {}

  public Book(
      String ISBN,
      String title,
      Genre genre,
      LocalDateTime publishedYear,
      int availableUnits,
      int totalUnits,
      Author author,
      Editor editor) {
    this.ISBN = ISBN;
    this.title = title;
    this.genre = genre;
    this.publishedYear = publishedYear;
    this.availableUnits = availableUnits;
    this.totalUnits = totalUnits;
    this.author = author;
    this.editor = editor;
  }

  public Book(
      int id,
      String ISBN,
      String title,
      Genre genre,
      LocalDateTime publishedYear,
      int availableUnits,
      int totalUnits,
      Author author,
      Editor editor) {
    this.id = id;
    this.ISBN = ISBN;
    this.title = title;
    this.genre = genre;
    this.publishedYear = publishedYear;
    this.availableUnits = availableUnits;
    this.totalUnits = totalUnits;
    this.author = author;
    this.editor = editor;
  }

  // Getters and Setters
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

  public LocalDateTime getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(LocalDateTime publishedYear) {
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
}
