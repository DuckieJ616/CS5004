package order.mapper;

import order.dto.FoodItemsDTO;
import order.dto.OrderDTO;
import order.dto.OrderDTOFromFE;
import order.dto.Restaurant;
import order.dto.UserDTO;

import order.entity.Order;
import order.mapper.OrderMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * Tests for verifying correctness of manual mapping logic
 * in OrderMapper.
 */
public class OrderMapperTest {

  @Test
  public void testMapOrderToOrderDTO() {

    FoodItemsDTO item = new FoodItemsDTO(
        1, "Pizza", "Cheese Pizza", false,
        10L, 100, 1
    );

    Restaurant rest = new Restaurant(
        1, "Green Apple", "2087 Mahuron Cir", "Cupertino", "Nice place"
    );

    UserDTO user = new UserDTO(
        1, "Cindy", "pw", "1st Santa Clara St", "San Jose"
    );

    Order order = new Order(10, List.of(item), rest, user);

    // Convert entity → DTO
    OrderDTO dto = OrderMapper.mapOrderToOrderDTO(order);

    Assertions.assertEquals(10, dto.getOrderId());
    Assertions.assertEquals("Pizza", dto.getFoodItemsList().get(0).getItemName());
    Assertions.assertEquals("Green Apple", dto.getRestaurant().getName());
  }
}

