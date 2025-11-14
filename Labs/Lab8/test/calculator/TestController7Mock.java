package calculator;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Mock test for Controller7.
 * This test should FAIL because Controller7 passes wrong arguments to add().
 */
public class TestController7Mock {

  @Test
  public void testController7FailsMock() throws IOException {
    Readable in = new StringReader("+ 2 3 q");
    Appendable out = new StringBuilder();

    MockModel mock = new MockModel();

    Controller7 controller = new Controller7(in, out);

    controller.go(mock);

    String expected = "Passed: 2 and 3" + System.lineSeparator();

    assertEquals(expected, mock.getLog());
  }
}
