package order.service;

import order.dto.FoodItemsDTO;
import order.dto.Restaurant;
import order.dto.UserDTO;
import order.dto.OrderDTOFromFE;
import order.dto.OrderDTO;

import order.entity.Order;
import order.repo.OrderRepo;
import order.service.OrderService;
import order.service.SequenceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Tests business logic inside OrderService.
 */
public class OrderServiceTest {

  @Test
  public void testSaveOrderInDb() {

    // mock repository
    OrderRepo repo = mock(OrderRepo.class);

    // real SequenceGenerator
    SequenceGenerator seq = new SequenceGenerator();

    // service under test
    OrderService service = new OrderService(repo, seq);

    // create FE DTO
    FoodItemsDTO item = new FoodItemsDTO(
        1, "Burger", "Beef Burger", false,
        8L, 50, 2
    );

    Restaurant restaurant = new Restaurant(
        2, "McDonalds", "123 St", "Boston", "Fast food"
    );

    OrderDTOFromFE dto = new OrderDTOFromFE(
        List.of(item), 1, restaurant
    );

    // when save is called, return nothing
    doAnswer(i -> null).when(repo).save(any(Order.class));

    // execute service
    OrderDTO result = service.saveOrderInDb(dto);

    Assertions.assertEquals(1, result.getOrderId());
    Assertions.assertEquals("Burger", result.getFoodItemsList().get(0).getItemName());
    Assertions.assertEquals("McDonalds", result.getRestaurant().getName());
  }
}

