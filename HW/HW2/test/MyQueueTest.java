// imports (JUnit 5)
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

  private MyQueue<String> sq;
  private MyQueue<Book>   bq;

  @BeforeEach
  void setUp() {
    sq = new MyQueue<>();
    bq = new MyQueue<>();
  }

  //isEmpty
  @Test
  void isEmpty_newQueue_true() {
    assertTrue(sq.isEmpty());
    assertEquals(0, sq.size());
  }

  @Test
  void isEmpty_afterEnqueue_false() {
    sq.enqueue("a");
    assertFalse(sq.isEmpty());
    assertEquals(1, sq.size());
  }

  //enqueue + dequeue (FIFO)
  @Test
  void enqueueDequeue_strings_fifo() {
    sq.enqueue("a");
    sq.enqueue("b");
    assertEquals("a", sq.dequeue());
    assertEquals("b", sq.dequeue());
  }

  @Test
  void dequeue_onEmpty_throws() {
    assertThrows(java.util.NoSuchElementException.class, () -> sq.dequeue());
    assertTrue(sq.isEmpty());
  }

  // peek
  @Test
  void peek_returnsHead_withoutRemoval() {
    sq.enqueue("x");
    sq.enqueue("y");
    assertEquals("x", sq.peek());
    assertFalse(sq.isEmpty());
    assertEquals(2, sq.size());
  }

  @Test
  void peek_onEmpty_throws() {
    assertThrows(java.util.NoSuchElementException.class, () -> sq.peek());
    assertTrue(sq.isEmpty());
  }

  // toString
  @Test
  void toString_formatsAsRequired() {
    assertEquals("Queue: ", sq.toString());
    sq.enqueue("hi");
    sq.enqueue("there");
    assertEquals("Queue: hi there", sq.toString());
  }

  // equals / hashCode
  @Test
  void equals_and_hashCode_match() {
    MyQueue<String> a = new MyQueue<>();
    MyQueue<String> b = new MyQueue<>();
    a.enqueue("1"); a.enqueue("2");
    b.enqueue("1"); b.enqueue("2");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());

    b.enqueue("3");
    assertNotEquals(a, b);
  }

  // generic with custom type
  @Test
  void worksWithCustomType() {
    bq.enqueue(new Book("Effective Java", "Joshua Bloch"));
    bq.enqueue(new Book("Clean Code", "Robert C. Martin"));
    assertEquals("\"Effective Java\" by Joshua Bloch", bq.peek().toString());
    assertEquals("\"Effective Java\" by Joshua Bloch", bq.dequeue().toString());
  }
}