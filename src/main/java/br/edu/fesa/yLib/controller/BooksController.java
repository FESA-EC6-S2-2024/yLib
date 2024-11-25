package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.dto.BookSearchOptionsDto;
import br.edu.fesa.yLib.dto.BookSearchResultDto;
import br.edu.fesa.yLib.model.Author;
import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.model.Editor;
import br.edu.fesa.yLib.model.Genre;
import br.edu.fesa.yLib.service.AuthorService;
import br.edu.fesa.yLib.service.BookService;
import br.edu.fesa.yLib.service.EditorService;
import br.edu.fesa.yLib.service.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Controller
@RequestMapping("/books")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private EditorService editorService;

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("editors", editorService.findAll());
        return "books/create";
    }

    @PostMapping("/create")
    public String createBook(@Valid @ModelAttribute Book book, BindingResult result, Model model) {
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
    public String showEditForm(@PathVariable int id, Model model) {
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
    public String updateBook(@PathVariable int id, @Valid @ModelAttribute Book book, BindingResult result, Model model) {
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
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'LIBRARIAN')")
    @GetMapping("/search")
    public String searchBooks(@ModelAttribute BookSearchOptionsDto searchOptions, Model model) {
        BookSearchResultDto result = bookService.searchBooks(
            searchOptions.getKeyword(),
            searchOptions.getEditor(),
            searchOptions.getGenre(),
            searchOptions.getAuthor(),
            searchOptions.getSort(),
            searchOptions.getPage(),
            searchOptions.getPageSize());

        // Collect distinct authors, genres, and editors
        Set<Author> distinctAuthors = new HashSet<>();
        Set<Genre> distinctGenres = new HashSet<>();
        Set<Editor> distinctEditors = new HashSet<>();

        for (Book book : result.getBookPage().getContent()) {
            distinctAuthors.add(book.getAuthor());
            distinctGenres.add(book.getGenre());
            distinctEditors.add(book.getEditor());
        }

        List<Author> authorsList = new ArrayList<>(distinctAuthors);
        List<Genre> genresList = new ArrayList<>(distinctGenres);
        List<Editor> editorsList = new ArrayList<>(distinctEditors);

        // Add results to the model
        model.addAttribute("searchOptions", searchOptions);
        model.addAttribute("books", result.getBookPage());
        model.addAttribute("authors", authorsList);
        model.addAttribute("genres", genresList);
        model.addAttribute("editors", editorsList);
        model.addAttribute("totalItems", result.getTotalItems());
        
        return "/books/search";
    }
}
