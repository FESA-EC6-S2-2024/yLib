package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Book;
import br.edu.fesa.yLib.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
}
