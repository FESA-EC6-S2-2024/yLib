package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.UserGender;
import br.edu.fesa.yLib.enumerator.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_USER", schema = "LIBRARY")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private int id;

    @NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Name must be at most 100 characters long.")
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email must be valid.")
    @Size(max = 100, message = "Email must be at most 100 characters long.")
    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters long.")
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Size(max = 64, message = "Secret must be at most 64 characters long.")
    @Column(name = "SECRET", nullable = true, length = 64)
    private String secret;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", nullable = false)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_GENDER", nullable = false)
    private UserGender userGender;

    @Column(name = "IMAGE", nullable = true)
    private String image;

    @NotNull(message = "2FA usage indication is required.")
    @Column(name = "IS_USING_2FA", nullable = false)
    private boolean isUsing2FA;

    @Transient
    private String confirmEmail;

    @Transient
    private String confirmPassword;

    public User() {
    }

    public User(
            String name,
            String email,
            String password,
            String secret,
            UserType userType,
            UserGender userGender,
            String image,
            boolean isUsing2FA) {
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
        this.password = password;
        this.secret = secret;
        this.userType = userType;
        this.userGender = userGender;
        this.image = image;
        this.isUsing2FA = isUsing2FA;
    }

    public User(
            int id,
            String name,
            String email,
            String password,
            String secret,
            UserType userType,
            UserGender userGender,
            String image,
            boolean isUsing2FA) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = LocalDateTime.now();
        this.password = password;
        this.secret = secret;
        this.userType = userType;
        this.userGender = userGender;
        this.image = image;
        this.isUsing2FA = isUsing2FA;
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

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public void setUsing2FA(boolean isUsing2FA) {
        this.isUsing2FA = isUsing2FA;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
