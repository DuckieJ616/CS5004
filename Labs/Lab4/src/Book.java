import java.util.Objects;

public final class Book {
  private final String title;
  private final String author;

  public Book(String title, String author) {
    if (title == null || author == null) throw new IllegalArgumentException("null title/author");
    this.title = title;
    this.author = author;
  }

  public String title() { return title; }
  public String author() { return author; }

  @Override
  public String toString() {
    return "\"" + title + "\" by " + author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return title.equals(book.title) && author.equals(book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author);
  }
}
