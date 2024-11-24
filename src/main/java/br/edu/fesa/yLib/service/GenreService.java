package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Genre;
import br.edu.fesa.yLib.repository.GenreRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo7
 */
@Service
public class GenreService {

  @Autowired private GenreRepository genreRepository;

  public List<Genre> findAll() {
    return genreRepository.findAll();
  }

  public Genre findById(UUID id) {
    return genreRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Genre not found"));
  }

  @Transactional
  public Genre save(Genre genre) {
    return genreRepository.save(genre);
  }

  @Transactional
  public Genre update(UUID id, Genre genreDetails) {
    Genre genre = findById(id);
    genre.setDescription(genreDetails.getDescription());
    return genreRepository.save(genre);
  }

  @Transactional
  public void delete(UUID id) {
    Genre genre = findById(id);
    genreRepository.delete(genre);
  }
}
