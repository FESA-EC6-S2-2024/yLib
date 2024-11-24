package br.edu.fesa.yLib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_AUTHORS", schema = "LIBRARY")
public class Author implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_AUTHOR")
  private int id;

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

  public Author() {}

  public Author(String name, String country, Date birthDate) {
    this.name = name;
    this.country = country;
    this.birthDate = birthDate;
  }

  public Author(int id, String name, String country, Date birthDate) {
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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}
