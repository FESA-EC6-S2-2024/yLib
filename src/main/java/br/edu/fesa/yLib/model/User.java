package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.UserGender;
import br.edu.fesa.yLib.enumerator.UserType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_USER", schema = "HOTEL")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_USER")
  private int id;

  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "REGISTRATION_DATE", nullable = false)
  private LocalDateTime registrationDate;

  @Column(name = "PASSWORD", nullable = false, length = 255)
  private String password;

  @Column(name = "AUTH_CODE", nullable = true, length = 6)
  private String authCode;

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_TYPE", nullable = false)
  private UserType userType;

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_GENDER", nullable = false)
  private UserGender userGender;

  public User() {}

  public User(
      String name,
      String email,
      LocalDateTime registrationDate,
      String password,
      String authCode,
      UserType userType,
      UserGender userGender) {
    this.name = name;
    this.email = email;
    this.registrationDate = registrationDate;
    this.password = password;
    this.authCode = authCode;
    this.userType = userType;
    this.userGender = userGender;
  }

  public User(
      int id,
      String name,
      String email,
      LocalDateTime registrationDate,
      String password,
      String authCode,
      UserType userType,
      UserGender userGender) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.registrationDate = registrationDate;
    this.password = password;
    this.authCode = authCode;
    this.userType = userType;
    this.userGender = userGender;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public UserGender getUserGender() {
    return userGender;
  }

  public void setUserGender(UserGender userGender) {
    this.userGender = userGender;
  }
}
