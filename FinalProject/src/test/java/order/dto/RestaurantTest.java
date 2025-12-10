package order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

  @Test
  public void testGettersAndSetters() {

    Restaurant r = new Restaurant();

    r.setId(1);
    r.setName("Pizza Hut");
    r.setAddress("123 Main St");
    r.setCity("Boston");
    r.setRestaurantDescription("Nice place");

    assertEquals(1, r.getId());
    assertEquals("Pizza Hut", r.getName());
    assertEquals("123 Main St", r.getAddress());
    assertEquals("Boston", r.getCity());
    assertEquals("Nice place", r.getRestaurantDescription());
  }
}

