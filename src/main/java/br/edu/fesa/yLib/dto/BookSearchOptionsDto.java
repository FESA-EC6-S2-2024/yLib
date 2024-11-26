package br.edu.fesa.yLib.dto;

import br.edu.fesa.yLib.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Grupo_7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSearchOptionsDto {
  private String keyword;

  @Builder.Default
  private String editor = null;

  @Builder.Default
  private String genre = null;

  @Builder.Default
  private String author = null;

  @Builder.Default
  private String sort = "title"; // Default sorting by title
                                 
  @Builder.Default
  private int page = 1; // Default page

  @Builder.Default
  private int pageSize = Constants.Defaults.PAGE_SIZE; // Default page size
}
