package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo7
 */
public enum LoanStatus {
  BORROWED(0),
  LATE(1); // Adicionei um id para o status LATE também

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
