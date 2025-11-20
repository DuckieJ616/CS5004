import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TextViewTest {

  private String getOutputAfterRunning(java.util.function.Consumer<TextView> action) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(out);
    TextView view = new TextView(ps);

    action.accept(view);
    return out.toString();
  }

  @Test
  public void testShowString() {
    String output = getOutputAfterRunning(v -> v.showString("abc"));

    assertTrue(output.contains("String: abc"));

    assertTrue(output.endsWith(System.lineSeparator()));
  }

  @Test
  public void testShowOptions() {
    String output = getOutputAfterRunning(TextView::showOptions);

    assertTrue(output.contains("E: Enter a string"));
    assertTrue(output.contains("Q: Quit the program"));
  }

  @Test
  public void testShowStringEntry() {
    String output = getOutputAfterRunning(TextView::showStringEntry);

    assertTrue(output.contains("Enter the string to be echoed"));
    assertTrue(output.startsWith("\n"));
  }

  @Test
  public void testShowOptionError() {
    String output = getOutputAfterRunning(TextView::showOptionError);

    assertTrue(output.contains("Invalid option."));

    assertTrue(output.startsWith("\n"));
  }
}
