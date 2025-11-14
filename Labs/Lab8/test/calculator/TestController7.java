package calculator;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class TestController7 {

  @Test
  public void testSimpleAddition() throws IOException {
    // Input as a string
    StringReader in = new StringReader("+ 5 3 + 11 12 q");

    // Output to a StringBuilder
    StringBuilder out = new StringBuilder();

    Controller7 controller = new Controller7(in, out);

    controller.go(new SimpleCalc7Model());

    assertEquals("8\n23\n", out.toString());
  }
}
