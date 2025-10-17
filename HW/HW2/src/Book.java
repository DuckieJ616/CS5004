import java.util.Objects;

/** helper type for generic tests. */
public class Book {
  private final String title;
  private final String author;

  public Book(String title, String author) {
    this.title  = title;
    this.author = author;
  }

  @Override
  public String toString() {
    return "\"" + title + "\" by " + author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book b)) return false;
    return Objects.equals(title, b.title) && Objects.equals(author, b.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author);
  }
}
