package br.edu.fesa.yLib.dto;

import java.util.ArrayList;
import java.util.List;

public class LoanCountByGenreDto {
  List<String> genres;
  List<Long> counts;

  public LoanCountByGenreDto() {
    genres = new ArrayList<String>();
    counts = new ArrayList<Long>();
  }

  public List<String> getGenres() {
    return genres;
  }

  public void addGenre(String genre) {
    genres.add(genre);
  }

  public List<Long> getCounts() {
    return counts;
  }

  public void addCount(Long count) {
    counts.add(count);
  }
}
