package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.service.BookService;
import br.edu.fesa.yLib.service.LoanService;
import br.edu.fesa.yLib.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/loans")
public class LoansController {

  @Autowired
  private LoanService loanService;

  @Autowired
  private UserService userService;

  @Autowired
  private BookService bookService;

  @GetMapping
  public String listLoans(Model model) {
    model.addAttribute("loans", loanService.findAll());
    return "loans/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("loan", new Loan());
    return "loans/create";
  }

  @PostMapping("/create")
  public String createLoan(@Valid @ModelAttribute Loan loan, BindingResult result) {
    if (result.hasErrors()) {
      return "loans/create";
    }
    loanService.save(loan);
    return "redirect:/loans";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable int id, Model model) {
    model.addAttribute("editor", loanService.findById(id));
    return "loans/edit";
  }

  @PostMapping("/edit/{id}")
  public String updateLoan(@PathVariable int id, @Valid @ModelAttribute Loan loan, BindingResult result) {
    if (result.hasErrors()) {
      return "loans/edit";
    }
    loanService.update(id, loan);
    return "redirect:/loans";
  }

  @GetMapping("/delete/{id}")
  public String deleteLoan(@PathVariable int id) {
    loanService.delete(id);
    return "redirect:/loans";
  }
}
