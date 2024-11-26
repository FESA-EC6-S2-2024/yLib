package br.edu.fesa.yLib.dto;

import br.edu.fesa.yLib.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

/**
 * @author Grupo_7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSearchResultDto {
  private Page<Book> bookPage;
  private long totalItems;
}
