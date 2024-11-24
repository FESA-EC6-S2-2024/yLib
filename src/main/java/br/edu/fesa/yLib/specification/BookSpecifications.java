package br.edu.fesa.yLib.specification;

import org.springframework.data.jpa.domain.Specification;

import br.edu.fesa.yLib.model.Book;

public class BookSpecifications {
  public static Specification<Book> hasKeyword(String keyword) {
    return (root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
  }

  public static Specification<Book> hasEditor(String editorId) {
    return (root, query, cb) -> cb.equal(root.join("editor").get("id"), editorId);
  }

  public static Specification<Book> hasGenre(String genreId) {
    return (root, query, cb) -> cb.equal(root.get("genre").get("id"), genreId);
  }

  public static Specification<Book> hasAuthor(String authorId) {
    return (root, query, cb) -> cb.equal(root.get("author").get("id"), authorId);
  }
}
