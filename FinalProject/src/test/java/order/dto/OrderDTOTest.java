package order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderDTOTest {

  @Test
  public void testGettersAndSetters() {
    OrderDTO dto = new OrderDTO();

    dto.setOrderId(100);
    dto.setFoodItemsList(List.of(new FoodItemsDTO()));
    dto.setRestaurant(new Restaurant());
    dto.setUserDTO(new UserDTO());

    assertEquals(100, dto.getOrderId());
    assertEquals(1, dto.getFoodItemsList().size());
    assertNotNull(dto.getRestaurant());
    assertNotNull(dto.getUserDTO());
  }
}

