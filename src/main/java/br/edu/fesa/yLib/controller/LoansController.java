package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.exception.BookNotAvailableException;
import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.service.BookService;
import br.edu.fesa.yLib.service.LoanService;
import br.edu.fesa.yLib.service.UserService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Grupo_7
 */
@Controller
@RequestMapping("/loans")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class LoansController {

  @Autowired private LoanService loanService;

  @Autowired private UserService userService;

  @Autowired private BookService bookService;

  @GetMapping
  public String listLoans(Model model) {
    model.addAttribute("loans", loanService.findAll());
    return "loans/list";
  }

  @PreAuthorize("hasAnyRole('CLIENT')")
  @GetMapping("/client")
  public String listClientLoans(Model model) {
    model.addAttribute("loans", loanService.findAll());
    return "loans/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("loan", new Loan());
    model.addAttribute("books", bookService.findAllAvailable());
    model.addAttribute("users", userService.findAllUsers());

    return "loans/create";
  }

  @PostMapping("/create")
  public String createLoan(@Valid @ModelAttribute Loan loan, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("books", bookService.findAllAvailable());
      model.addAttribute("users", userService.findAllUsers());

      return "loans/create";
    }

    try {
      loanService.createLoan(loan);
    } catch (BookNotAvailableException e) {
      result.rejectValue("book", "error.book", e.getMessage());
      model.addAttribute("books", bookService.findAllAvailable());
      model.addAttribute("users", userService.findAllUsers());
    }
    return "redirect:/loans";
  }

  @GetMapping("/complete/{id}")
  public String completeLoan(@PathVariable UUID id) {
    loanService.completeLoan(id);
    return "redirect:/loans";
  }

  @GetMapping("/undo/{id}")
  public String undoLoan(@PathVariable UUID id) {
    loanService.undoLoan(id);
    return "redirect:/loans";
  }

  @GetMapping("/cancel/{id}")
  public String deleteLoan(@PathVariable UUID id) {
    loanService.canceLoan(id);
    return "redirect:/loans";
  }
}
