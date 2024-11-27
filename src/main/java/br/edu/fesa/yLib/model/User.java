package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.UserGender;
import br.edu.fesa.yLib.enumerator.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

/**
 * @author Grupo_7
 */
@Entity
@Table(name = "TB_USERS", schema = "LIBRARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(name = "ID_USER", columnDefinition = "UUID", updatable = false, nullable = false)
  private UUID id;

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
  @Builder.Default
  private LocalDateTime registrationDate = LocalDateTime.now();

  @NotBlank(message = "Password is required.")
  @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters long.")
  @Column(name = "PASSWORD", nullable = false, length = 255)
  private String password;

  @Size(max = 64, message = "Secret must be at most 64 characters long.")
  @Column(name = "SECRET", nullable = true, length = 64)
  private String secret;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "User type is required.")
  @Column(name = "USER_TYPE", nullable = false)
  @Builder.Default
  private UserType userType = UserType.CLIENT; // default type

  @Enumerated(EnumType.STRING)
  @Column(name = "USER_GENDER", nullable = false)
  private UserGender userGender;

  @Column(name = "IMAGE", nullable = true)
  private String image;

  @NotNull(message = "2FA usage indication is required.")
  @Column(name = "IS_USING_2FA", nullable = false)
  private boolean isUsing2FA;

  // loans a user has
  @OneToMany(mappedBy = "user")
  private List<Loan> loans;

  @Transient private String confirmEmail;

  @Transient private String confirmPassword;
}
