package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.dto.BookSearchResultDto;
import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.repository.BookRepository;
import br.edu.fesa.yLib.specification.BookSpecifications;
import br.edu.fesa.yLib.util.Constants;
import jakarta.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Optional<Book> findById(int id) {
    return bookRepository.findById(id);
  }

  @Transactional
  public Book createBook(@Valid Book book) {

    return bookRepository.save(book);
  }

  @Transactional
  public Book updateBook(int id, @Valid Book updatedBook) {
    Book existingBook = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Book not found"));

    existingBook.setISBN(updatedBook.getISBN());
    existingBook.setTitle(updatedBook.getTitle());
    existingBook.setGenre(updatedBook.getGenre());
    existingBook.setPublishedYear(updatedBook.getPublishedYear());
    existingBook.setAvailableUnits(updatedBook.getAvailableUnits());
    existingBook.setTotalUnits(updatedBook.getTotalUnits());
    existingBook.setAuthor(updatedBook.getAuthor());
    existingBook.setEditor(updatedBook.getEditor());
    existingBook.setImage(updatedBook.getImage());

    return bookRepository.save(existingBook);
  }

  @Transactional
  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }

  public BookSearchResultDto searchBooks(String keyword, String editor, String genre, String author, String sort, int page,
      int pageSize) throws IllegalArgumentException {

    pageSize = Math.min(pageSize, Constants.Defaults.MAX_PAGE_SIZE);

    Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(sort));

    Specification<Book> spec = Specification.where(keyword != null ? BookSpecifications.hasKeyword(keyword) : null)
        .and(!StringUtils.isEmpty(editor) ? BookSpecifications.hasEditor(editor) : null)
        .and(!StringUtils.isEmpty(genre) ? BookSpecifications.hasGenre(genre) : null)
        .and(!StringUtils.isEmpty(author) ? BookSpecifications.hasAuthor(author) : null);

    Page<Book> result = bookRepository.findAll(spec, pageable);
    long count = bookRepository.count(spec);
    
    return new BookSearchResultDto(result, count);
  }
}
