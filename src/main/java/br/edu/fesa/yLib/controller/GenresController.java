package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Genre;
import br.edu.fesa.yLib.service.GenreService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Grupo_7
 */
@Controller
@RequestMapping("/genres")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class GenresController {

  @Autowired private GenreService genreService;

  @GetMapping
  public String listGenres(Model model) {
    model.addAttribute("genres", genreService.findAll());
    return "genres/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("genre", Genre.builder().build());
    return "genres/create";
  }

  @PostMapping("/create")
  public String createGenre(@Valid @ModelAttribute Genre genre, BindingResult result) {
    if (result.hasErrors()) {
      return "genres/create";
    }
    genreService.save(genre);
    return "redirect:/genres";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable UUID id, Model model) {
    model.addAttribute("genre", genreService.findById(id));
    return "genres/edit";
  }

  @PostMapping("/edit/{id}")
  public String updateGenre(
      @PathVariable UUID id, @Valid @ModelAttribute Genre genre, BindingResult result) {
    if (result.hasErrors()) {
      return "genres/edit";
    }
    genreService.update(id, genre);
    return "redirect:/genres";
  }

  @GetMapping("/delete/{id}")
  public String deleteGenre(@PathVariable UUID id) {
    genreService.delete(id);
    return "redirect:/genres";
  }
}
