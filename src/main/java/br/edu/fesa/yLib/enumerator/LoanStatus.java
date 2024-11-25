package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo_7
 */
public enum LoanStatus {
  BORROWED(0),
  RETURNED(1),
  CANCELED(2);

  private final int id;

  // Construtor para o enum
  LoanStatus(int id) {
    this.id = id;
  }

  // Getter para o id
  public int getId() {
    return id;
  }
}
