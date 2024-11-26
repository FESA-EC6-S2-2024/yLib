package br.edu.fesa.yLib.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo_7
 */
public class LoanCountByMonthDto {
  public List<Integer> months;
  public List<Long> counts;

  public LoanCountByMonthDto() {
    this.months = new ArrayList<Integer>();
    this.counts = new ArrayList<Long>();
  }

  public List<Integer> getMonths() {
    return this.months;
  }

  public void addMonth(Integer month) {
    this.months.add(month);
  }

  public List<Long> getCounts() {
    return this.counts;
  }

  public void addCount(Long count) {
    this.counts.add(count);
  }
}
