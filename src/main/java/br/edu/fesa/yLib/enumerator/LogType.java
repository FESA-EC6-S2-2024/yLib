package br.edu.fesa.yLib.enumerator;

/**
 * @author Grupo7
 */
public enum LogType {
  ERROR(0),
  LOGIN(1),
  LOGOUT(2),
  SESSION(3),
  INFO(4),
  WARNING(5),
  DEBUG(6);

  private final int id;

  LogType(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
