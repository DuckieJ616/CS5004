package order.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generates sequential numeric IDs for orders.
 * <p>
 * This class provides a simple thread-safe mechanism for generating
 * increasing order IDs. It simulates how an auto-incrementing primary
 * key might work in a real system, while remaining independent of any
 * database or framework.
 *
 * <p>This supports object-oriented design principles by separating
 * ID-generation logic from the order entity and service layers,
 * following the Single Responsibility Principle (SRP).</p>
 */
public class SequenceGenerator {

  /** Internal counter that stores the current maximum order ID. */
  private final AtomicInteger counter = new AtomicInteger(0);

  /**
   * Returns the next sequential order ID.
   *
   * @return the next incremented integer value
   */
  public int generateNextOrderId() {
    return counter.incrementAndGet();
  }
}


