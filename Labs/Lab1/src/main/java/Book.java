public class Book {
  private String title;
  private String author;
  private int pages;

  /**
   * Creates a new Book.
   * @param title  book title
   * @param author book author
   * @param pages  number of pages
   */
  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  /** @return the title */
  public String getTitle()  { return title; }
  /** @return the author */
  public String getAuthor() { return author; }
  /** @return the number of pages */
  public int getPages()     { return pages; }
}
