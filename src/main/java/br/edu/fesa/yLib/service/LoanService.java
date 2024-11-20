package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LoanService implements GenericService<Loan, Integer> {

  @Autowired
  private LoanRepository loanRepository;

  public List<Loan> findAll() {
    return loanRepository.findAll();
  }

  public Loan findById(Integer id) {
    return loanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
  }

  @Transactional
  public Loan save(Loan loan) {
    return loanRepository.save(loan);
  }

  @Transactional
  public void update(Integer id, Loan loanDetails) {
    throw new UnsupportedOperationException();
  }

  @Transactional
  public void delete(Integer id) {
    Loan loan = findById(id);
    loanRepository.delete(loan);
  }
}
