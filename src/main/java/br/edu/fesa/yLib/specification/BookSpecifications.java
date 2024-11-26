package br.edu.fesa.yLib.specification;

import br.edu.fesa.yLib.model.Book;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Grupo_7
 */
public class BookSpecifications {

  public static Specification<Book> hasKeyword(String keyword) {
    return (root, query, cb) ->
        cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
  }

  public static Specification<Book> hasEditor(String editorId) {
    return (root, query, cb) -> {
      // Convertendo o editorId (String) para UUID
      UUID editorUuid = UUID.fromString(editorId);
      return cb.equal(root.join("editor").get("id"), editorUuid);
    };
  }

  public static Specification<Book> hasGenre(String genreId) {
    return (root, query, cb) -> {
      // Convertendo o genreId (String) para UUID
      UUID genreUuid = UUID.fromString(genreId);
      return cb.equal(root.get("genre").get("id"), genreUuid);
    };
  }

  public static Specification<Book> hasAuthor(String authorId) {
    return (root, query, cb) -> {
      // Convertendo o authorId (String) para UUID
      UUID authorUuid = UUID.fromString(authorId);
      return cb.equal(root.get("author").get("id"), authorUuid);
    };
  }
}
