package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo7
 */
public enum UserGender {
  MALE(0),
  FEMALE(1),
  OTHER(2);

  private final int id;

  // Construtor para o enum
  UserGender(int id) {
    this.id = id;
  }

  // Getter para o id
  public int getId() {
    return id;
  }
}
