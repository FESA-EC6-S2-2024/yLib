package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo_7
 */
public enum UserType {
  CLIENT(0),
  LIBRARIAN(1),
  ADMIN(2);

  private final int id;

  // Construtor para o enum
  UserType(int id) {
    this.id = id;
  }

  // Getter para o id
  public int getId() {
    return id;
  }
}
