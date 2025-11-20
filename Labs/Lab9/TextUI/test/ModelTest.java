import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Model (IModel/Model).
 */
public class ModelTest {

  @Test
  public void testInitialStateAndSetString() {
    IModel model = new Model();

    assertEquals("", model.getString());

    model.setString("hello");
    assertEquals("hello", model.getString());
  }

  @Test
  public void testOverwriteString() {
    IModel model = new Model();
    model.setString("first");
    model.setString("second");

    assertEquals("second", model.getString());
    assertNotEquals("first", model.getString());
  }
}

