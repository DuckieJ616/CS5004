package order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodItemsDTOTest {

  @Test
  public void testGettersAndSetters() {
    FoodItemsDTO item = new FoodItemsDTO();

    item.setId(1);
    item.setItemName("Pizza");
    item.setItemDescription("Cheese Pizza");
    item.setVeg(false);
    item.setPrice(12L);
    item.setQuantity(3);
    item.setRestaurantId(5);

    assertEquals(1, item.getId());
    assertEquals("Pizza", item.getItemName());
    assertEquals("Cheese Pizza", item.getItemDescription());
    assertFalse(item.isVeg());
    assertEquals(12L, item.getPrice());
    assertEquals(3, item.getQuantity());
    assertEquals(5, item.getRestaurantId());
  }
}

