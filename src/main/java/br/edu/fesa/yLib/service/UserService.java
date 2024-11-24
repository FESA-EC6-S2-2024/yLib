package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.enumerator.UserGender;
import br.edu.fesa.yLib.exception.UserWithEmailAlreadyExistsException;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo7
 */
@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Transactional
  public User registerUser(User user) throws IllegalArgumentException {
    // Verificar se email e confirmação de email coincidem
    if (!user.getEmail().equals(user.getConfirmEmail())) {
      throw new IllegalArgumentException("Emails do not match");
    }

    // Verificar se senha e confirmação de senha coincidem
    if (!user.getPassword().equals(user.getConfirmPassword())) {
      throw new IllegalArgumentException("Passwords do not match");
    }

    if (userRepository.existsByEmail(user.getEmail())) {
      throw new UserWithEmailAlreadyExistsException();
    }

    // Configurar campos adicionais
    user.setPassword(passwordEncoder.encode(user.getPassword())); // Codificar senha
    user.setUserGender(UserGender.OTHER); // Define gênero padrão

    return userRepository.save(user);
  }

  @Transactional
  public User createUser(User user) throws IllegalArgumentException {
    if (userRepository.existsByEmail(user.getEmail())) {
      throw new UserWithEmailAlreadyExistsException();
    }

    // Configurar campos adicionais
    user.setPassword(passwordEncoder.encode(user.getPassword())); // Codificar senha
    user.setUserGender(UserGender.OTHER); // Define gênero padrão
    user.setRegistrationDate(LocalDateTime.now()); // Define data de registro

    return userRepository.save(user);
  }

  public Optional<User> findUserById(UUID id) {
    return userRepository.findById(id);
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public void updateUser(UUID id, User user) {
    var res = userRepository.findById(id);

    if (res.isEmpty()) {
      throw new IllegalArgumentException("User not found");
    }

    if (userRepository.existsByEmailAndIdNot(user.getEmail(), user.getId())) {
      throw new UserWithEmailAlreadyExistsException();
    }

    User userToUpdate = res.get();
    userToUpdate.setName(user.getName());
    userToUpdate.setEmail(user.getEmail());
    userToUpdate.setUserType(user.getUserType());
    userToUpdate.setUserGender(UserGender.OTHER);
    userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));

    userRepository.save(userToUpdate);
  }

  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }
}
