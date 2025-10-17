import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * A simple generic FIFO queue backed by an {@link ArrayList}.
 * <p>
 * Supports enqueue (tail), dequeue (head), peek (head without removal),
 * and emptiness check. Works with reference types (e.g., String, Integer,
 * custom classes). Primitive types are not supported directly; use wrappers.
 *
 * @param <T> element type stored in the queue
 */
public class MyQueue<T> {

  /** Underlying storage (head at index 0, tail at last index). */
  private final ArrayList<T> data;

  /** Creates an empty queue. */
  public MyQueue() {
    this.data = new ArrayList<>();
  }

  /**
   * Adds an element to the tail of the queue.
   *
   * @param e element to add
   */
  public void enqueue(T e) {
    data.add(e);
  }

  /**
   * Removes and returns the head element.
   *
   * @return head element
   * @throws NoSuchElementException if the queue is empty
   */
  public T dequeue() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("dequeue on empty queue");
    }
    return data.remove(0); // FIFO: remove head
  }

  /**
   * Returns the head element without removing it.
   *
   * @return head element
   * @throws NoSuchElementException if the queue is empty
   */
  public T peek() {
    if (data.isEmpty()) {
      throw new NoSuchElementException("peek on empty queue");
    }
    return data.get(0);
  }

  /**
   * @return {@code true} iff the queue has no elements
   */
  public boolean isEmpty() {
    return data.isEmpty();
  }

  /** Optional but handy for tests. */
  public int size() {
    return data.size();
  }

  /**
   * Returns "Queue: " followed by each element's {@code toString()},
   * separated by a single space. Empty queue prints just "Queue: ".
   */
  @Override
  public String toString() {
    StringJoiner sj = new StringJoiner(" ", "Queue: ", "");
    for (T t : data) {
      sj.add(String.valueOf(t));
    }
    return sj.toString();
  }

  /** Queues are equal if they are the same type and contain equal elements in the same order. */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MyQueue<?> other)) return false;
    return Objects.equals(this.data, other.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }
}
