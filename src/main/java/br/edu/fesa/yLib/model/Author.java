package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_AUTHOR", schema = "LIBRARY")
public class Author implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_AUTHOR")
  private int id;

  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @Column(name = "COUNTRY", nullable = false, length = 50)
  private String country;

  @Column(name = "BIRTH_DATE", nullable = false)
  private LocalDateTime birthDate;

  public Author() {}

  public Author(String name, String country, LocalDateTime birthDate) {
    this.name = name;
    this.country = country;
    this.birthDate = birthDate;
  }

  public Author(int id, String name, String country, LocalDateTime birthDate) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.birthDate = birthDate;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }
}
