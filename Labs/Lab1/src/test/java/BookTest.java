import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book book1, book2, book3;

  @BeforeEach
  void setUp() {
    book1 = new Book("Math",      "JC",       36);
    book2 = new Book("English",   "Charlie",  25);
    book3 = new Book("Chemistry", "Dr.Zhang", 45);
  }

  @Test
  void getTitle() {
    assertEquals("Math",      book1.getTitle());
    assertEquals("English",   book2.getTitle());
    assertEquals("Chemistry", book3.getTitle());
  }

  @Test
  void getAuthor() {
    assertEquals("JC",        book1.getAuthor());
    assertEquals("Charlie",   book2.getAuthor());
    assertEquals("Dr.Zhang",  book3.getAuthor());
  }

  @Test
  void getPages() {
    assertEquals(36, book1.getPages());
    assertEquals(25, book2.getPages());
    assertEquals(45, book3.getPages());
  }
}