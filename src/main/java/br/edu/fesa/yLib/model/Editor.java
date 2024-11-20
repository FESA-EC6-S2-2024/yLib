package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author Grupo7
 */
@Entity
@Table(name = "TB_EDITOR", schema = "LIBRARY")
public class Editor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_EDITOR")
  private int id;

  @Column(name = "NAME", nullable = false, length = 100)
  @NotEmpty(message = "Name can not be empty")
  private String name;

  public Editor() {}

  public Editor(String name) {
    this.name = name;
  }

  public Editor(int id, String name) {
    this.id = id;
    this.name = name;
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
}
