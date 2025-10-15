import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {

  private final Book a1 = new Book("Effective Java", "Joshua Bloch");
  private final Book a2 = new Book("Java Puzzlers", "Joshua Bloch");
  private final Book b1 = new Book("Clean Code", "Robert C. Martin");
  private final Book c1 = new Book("Design Patterns", "Erich Gamma");

  @Test
  void empty_size() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.size());
    assertEquals("[]", empty.toString());
  }

  @Test
  void empty_add() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks one = empty.add(a1);
    assertEquals(1, one.size());
    assertTrue(one.contains(a1));
  }

  @Test
  void empty_contains() {
    IListOfBooks empty = new EmptyNode();
    assertFalse(empty.contains(a1));
    assertFalse(empty.contains(b1));
  }

  @Test
  void empty_countByAuthor() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.countByAuthor("Anyone"));
    assertEquals(0, empty.countByAuthor("Joshua Bloch"));
  }

  @Test
  void empty_toString() {
    IListOfBooks empty = new EmptyNode();
    assertEquals("[]", empty.toString());
    assertTrue(empty.toString().startsWith("[") && empty.toString().endsWith("]"));
  }

  private IListOfBooks sampleList() {
    return new EmptyNode().add(a1).add(a2).add(b1).add(c1);
  }

  @Test
  void element_size() {
    IListOfBooks xs = sampleList();
    assertEquals(4, xs.size());
    assertEquals(1, new EmptyNode().add(a1).size());
  }

  @Test
  void element_add() {
    IListOfBooks xs = sampleList();
    IListOfBooks ys = xs.add(new Book("Refactoring", "Martin Fowler"));
    assertEquals(xs.size() + 1, ys.size());
    assertTrue(ys.contains(new Book("Refactoring", "Martin Fowler")));
  }

  @Test
  void element_contains() {
    IListOfBooks xs = sampleList();
    assertTrue(xs.contains(a1));
    assertFalse(xs.contains(new Book("Non-Existing", "Nobody")));
  }

  @Test
  void element_countByAuthor() {
    IListOfBooks xs = sampleList();
    assertEquals(2, xs.countByAuthor("Joshua Bloch"));
    assertEquals(1, xs.countByAuthor("Robert C. Martin"));
  }

  @Test
  void element_toString() {
    IListOfBooks xs = sampleList();
    String s = xs.toString();
    assertTrue(s.startsWith("[") && s.endsWith("]"));
    assertTrue(s.contains("\"Effective Java\" by Joshua Bloch"));
  }
}