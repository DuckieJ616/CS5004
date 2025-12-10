package order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderDTOFromFETest {

  @Test
  public void testGettersAndSetters() {
    OrderDTOFromFE dto = new OrderDTOFromFE();

    // Create a Food Item
    FoodItemsDTO item = new FoodItemsDTO();
    item.setId(1);

    List<FoodItemsDTO> foodList = List.of(item);

    // Create Restaurant object
    Restaurant rest = new Restaurant();
    rest.setId(20);
    rest.setName("Pizza Hut");
    rest.setAddress("123 Main St");
    rest.setCity("Boston");
    rest.setRestaurantDescription("Famous pizza chain");

    // Set values
    dto.setFoodItemsList(foodList);
    dto.setUserId(10);
    dto.setRestaurant(rest);

    // Assertions
    assertEquals(10, dto.getUserId());
    assertEquals(1, dto.getFoodItemsList().size());

    // Restaurant assertions
    assertEquals(20, dto.getRestaurant().getId());
    assertEquals("Pizza Hut", dto.getRestaurant().getName());
    assertEquals("123 Main St", dto.getRestaurant().getAddress());
    assertEquals("Boston", dto.getRestaurant().getCity());
    assertEquals("Famous pizza chain", dto.getRestaurant().getRestaurantDescription());
  }
}

