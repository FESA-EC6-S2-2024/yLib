package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.dto.LoanCountByGenreDto;
import br.edu.fesa.yLib.dto.LoanCountByMonthDto;
import br.edu.fesa.yLib.service.BookService;
import br.edu.fesa.yLib.service.LoanService;
import br.edu.fesa.yLib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grupo_7
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired private BookService bookService;

  @Autowired private UserService userService;

  @Autowired private LoanService loanService;

  @GetMapping({"/", "/home"})
  public String home(Model model) {
    int totalBooks = bookService.countBooks();
    int totalAvailableBooks = bookService.countAvailableBooks();
    int totalUsers = userService.countUsers();
    int totalLoans = loanService.countLoans();
    int totalActiveLoans = loanService.countActiveLoans();

    LoanCountByMonthDto loansByMonth = loanService.countLoansInCurrentYearByMonth();
    LoanCountByGenreDto loansByGenre = loanService.countLoansByGenre();

    // if (!isAuthenticated()) return "/errors/unauthorized";

    // if user is admin: load dashboard data

    model.addAttribute("totalBooks", totalBooks);
    model.addAttribute("totalAvailableBooks", totalAvailableBooks);
    model.addAttribute("totalUsers", totalUsers);
    model.addAttribute("totalLoans", totalLoans);
    model.addAttribute("totalActiveLoans", totalActiveLoans);
    model.addAttribute("loansByMonth", loansByMonth);
    model.addAttribute("loansByGenre", loansByGenre);

    return "index";
  }

  private boolean isAuthenticated() {
    return SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
        && !SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal()
            .equals("anonymousUser");
  }
}
