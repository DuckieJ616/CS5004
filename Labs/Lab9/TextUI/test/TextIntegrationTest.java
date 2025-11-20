import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class TextIntegrationTest {

  @Test
  public void testSetAndGetStringFlow() {

    String simulatedInput = "E\nhello\nQ\n";

    ByteArrayInputStream in =
        new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(out);

    IModel model = new Model();
    IView view = new TextView(ps);
    IController controller = new TextController(model, in, view);

    controller.go();

    String output = out.toString();

    assertEquals("hello", model.getString());

  }

  @Test
  public void testInvalidOptionShowsError() {
    String simulatedInput = "E\nhello\nQ\n";

    ByteArrayInputStream in =
        new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(out);

    IModel model = new Model();
    IView view = new TextView(ps);
    IController controller = new TextController(model, in, view);

    controller.go();

    String output = out.toString();

    assertEquals("hello", model.getString());

  }
}
