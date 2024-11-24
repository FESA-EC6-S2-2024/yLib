package br.edu.fesa.yLib.dto;

import br.edu.fesa.yLib.util.Constants;

public class BookSearchOptionsDto {
  private String keyword;
  private String editor = null;
  private String genre = null;
  private String author = null;
  private String sort = "title"; // Default sorting by title
  private int page = 1; // Default page
  private int pageSize = Constants.Defaults.PAGE_SIZE; // Default page size

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

}
