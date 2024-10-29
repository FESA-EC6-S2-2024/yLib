package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.repository.BookRepository;
import br.edu.fesa.yLib.repository.LoanRepository;
import br.edu.fesa.yLib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String getLoans(Model model) {
        List<Loan> loans = loanRepository.findAll();
        model.addAttribute("loans", loans);
        return "loan/list"; // Return the view name for listing loans
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan/form"; // Return the view name for the loan creation form
    }

    @PostMapping
    public String create(@ModelAttribute Loan loan) {
        loanRepository.save(loan);
        return "redirect:/loans"; // Redirect to the loans list after creation
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isPresent()) {
            model.addAttribute("loan", loan.get());
            return "loan/form"; // Return the view name for the edit form
        } else {
            return "redirect:/loans"; // Redirect if loan not found
        }
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Loan updatedLoan) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isPresent()) {
            Loan loan = existingLoan.get();
            // Update fields as necessary
            loan.setField1(updatedLoan.getField1());
            loan.setField2(updatedLoan.getField2());
            loanRepository.save(loan);
        }
        return "redirect:/loans"; // Redirect to the loans list after updating
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        loanRepository.deleteById(id);
        return "redirect:/loans"; // Redirect to the loans list after deletion
    }
}
