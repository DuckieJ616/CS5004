package calculator;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
public class TestController6 {

    @Test
    public void testSimpleAddition() throws IOException {
      // Input as a string
      StringReader in = new StringReader("+ 5 3 + 11 12 q");

      // Output to a StringBuilder
      StringBuilder out = new StringBuilder();

      Controller6 controller = new Controller6(in, out);

      // Run the calculator
      controller.go(new SimpleCalc6Model());

      // This should print "8 and then 23" to the console
      // System.out.println(out);

      assertEquals("8\n23\n", out.toString());
    }
  }
