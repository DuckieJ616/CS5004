package order.service;

import order.service.SequenceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the SequenceGenerator class to ensure IDs
 * are generated sequentially and correctly.
 */
public class SequenceGeneratorTest {

  @Test
  public void testSequenceIncrementsCorrectly() {
    SequenceGenerator generator = new SequenceGenerator();

    int id1 = generator.generateNextOrderId();
    int id2 = generator.generateNextOrderId();

    Assertions.assertEquals(1, id1);
    Assertions.assertEquals(2, id2);
  }
}

