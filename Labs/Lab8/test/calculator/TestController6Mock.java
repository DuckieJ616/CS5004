package calculator;

import org.junit.Test;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class TestController6Mock {

  @Test
  public void testController6PassesMock() throws Exception {
    Readable input = new StringReader("+ 2 3 q");
    Appendable out = new StringBuilder();

    MockModel mock = new MockModel();
    Controller6 controller = new Controller6(input, out);

    controller.go(mock);

    String expected = "Passed: 2 and 3" + System.lineSeparator();
    assertEquals(expected, mock.getLog());
  }
}

