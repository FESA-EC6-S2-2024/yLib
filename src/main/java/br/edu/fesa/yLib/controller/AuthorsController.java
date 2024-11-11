package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Author;
import br.edu.fesa.yLib.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/authors")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/create";
    }

    @PostMapping("/create")
    public String createAuthor(@Valid @ModelAttribute Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "authors/create";
        }
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "authors/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAuthor(@PathVariable int id, @Valid @ModelAttribute Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "authors/edit";
        }
        authorService.update(id, author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable int id) {
        authorService.delete(id);
        return "redirect:/authors";
    }
}

