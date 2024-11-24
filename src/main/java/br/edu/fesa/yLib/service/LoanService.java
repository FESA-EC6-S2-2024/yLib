package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Loan;
import br.edu.fesa.yLib.repository.LoanRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo7
 */
@Service
public class LoanService implements GenericService<Loan, UUID> {

  @Autowired private LoanRepository loanRepository;

  public List<Loan> findAll() {
    return loanRepository.findAll();
  }

  public Loan findById(UUID id) {
    return loanRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
  }

  @Transactional
  public Loan save(Loan loan) {
    return loanRepository.save(loan);
  }

  @Transactional
  public void update(UUID id, Loan loanDetails) {
    throw new UnsupportedOperationException();
  }

  @Transactional
  public void delete(UUID id) {
    Loan loan = findById(id);
    loanRepository.delete(loan);
  }
}
