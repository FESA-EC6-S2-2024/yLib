package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo7
 */
public enum HistoryType {
  ERROR(0),
  LOGIN(1);

  private final int id;

  // Construtor para o enum
  HistoryType(int id) {
    this.id = id;
  }

  // Getter para o id
  public int getId() {
    return id;
  }
}
