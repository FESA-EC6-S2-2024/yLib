package br.edu.fesa.yLib.dto;

import br.edu.fesa.yLib.model.Book;
import org.springframework.data.domain.Page;

/**
 * @author Grupo_7
 */
public class BookSearchResultDto {
  private Page<Book> bookPage;
  private long totalItems;

  public BookSearchResultDto(Page<Book> bookPage, long totalItems) {
    this.bookPage = bookPage;
    this.totalItems = totalItems;
  }

  public Page<Book> getBookPage() {
    return bookPage;
  }

  public void setBookPage(Page<Book> bookPage) {
    this.bookPage = bookPage;
  }

  public long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(long totalItems) {
    this.totalItems = totalItems;
  }
}
