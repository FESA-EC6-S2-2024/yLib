package br.edu.fesa.yLib.dto;

/**
 * @author Grupo_7
 */
public interface GenreLoansQueryResult {
  String getGenre(); // Matches `g.description` in the query

  Long getTotalLoans(); // Matches `COUNT(l)` in the query
}
