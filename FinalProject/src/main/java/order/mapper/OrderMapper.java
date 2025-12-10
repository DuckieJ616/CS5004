package order.mapper;

import order.dto.OrderDTO;
import order.dto.OrderDTOFromFE;
import order.entity.Order;

/**
 * Mapper class responsible for converting between Order entities
 * and DTO objects. This class replaces the MapStruct implementation
 * to keep the project self-contained and aligned with CS5004
 * object-oriented design requirements.
 *
 * <p>By isolating mapping logic here, we follow the Single
 * Responsibility Principle (SRP) and avoid placing conversion
 * code in the controller or service layers.</p>
 */
public class OrderMapper {

  /**
   * Converts an Order entity into an OrderDTO for returning
   * structured data to the client or controller layer.
   *
   * @param order the Order entity to convert
   * @return a corresponding OrderDTO representation
   */
  public static OrderDTO mapOrderToOrderDTO(Order order) {
    return new OrderDTO(
        order.getOrderId(),
        order.getFoodItemsList(),
        order.getRestaurant(),
        order.getUserDTO()
    );
  }

  /**
   * Converts a front-end submitted DTO into an Order entity.
   * <p>
   * Note: The orderId must be generated separately via
   * SequenceGenerator and injected before saving the entity.
   *
   * @param dto the DTO received from the client
   * @param generatedOrderId the generated order ID
   * @return a corresponding Order entity
   */
  public static Order mapDTOFromFEToOrder(OrderDTOFromFE dto, int generatedOrderId) {
    return new Order(
        generatedOrderId,
        dto.getFoodItemsList(),
        dto.getRestaurant(),
        null // userDTO intentionally left null for project scope
    );
  }
}

