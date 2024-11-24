package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.service.AuthorService;
import br.edu.fesa.yLib.service.BookService;
import br.edu.fesa.yLib.service.EditorService;
import br.edu.fesa.yLib.service.GenreService;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Grupo7
 */
@Controller
@RequestMapping("/books")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class BooksController {

  @Autowired private BookService bookService;

  @Autowired private AuthorService authorService;

  @Autowired private EditorService editorService;

  @Autowired private GenreService genreService;

  @GetMapping
  public String listBooks(Model model) {
    model.addAttribute("books", bookService.findAll());
    return "books/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("book", new Book());
    var a = genreService.findAll();

    model.addAttribute("genres", genreService.findAll());
    model.addAttribute("authors", authorService.findAll());
    model.addAttribute("editors", editorService.findAll());
    return "books/create";
  }

  @PostMapping("/create")
  public String createBook(
      @Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("genres", genreService.findAll());
      model.addAttribute("authors", authorService.findAll());
      model.addAttribute("editors", editorService.findAll());
      return "books/create";
    }
    bookService.createBook(book);
    return "redirect:/books";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable UUID id, Model model) {
    Optional<Book> bookOpt = bookService.findById(id);
    if (bookOpt.isEmpty()) {
      return "redirect:/books";
    }
    model.addAttribute("book", bookOpt.get());
    model.addAttribute("genres", genreService.findAll());
    model.addAttribute("authors", authorService.findAll());
    model.addAttribute("editors", editorService.findAll());
    return "books/edit";
  }

  @PostMapping("/edit/{id}")
  public String updateBook(
      @PathVariable UUID id,
      @Valid @ModelAttribute("book") Book book,
      BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("genres", genreService.findAll());
      model.addAttribute("authors", authorService.findAll());
      model.addAttribute("editors", editorService.findAll());
      return "books/edit";
    }
    bookService.updateBook(id, book);
    return "redirect:/books";
  }

  @GetMapping("/delete/{id}")
  public String deleteBook(@PathVariable UUID id) {
    bookService.deleteBook(id);
    return "redirect:/books";
  }
}
