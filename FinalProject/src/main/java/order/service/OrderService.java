package order.service;

import order.dto.OrderDTO;
import order.dto.OrderDTOFromFE;
import order.service.OrderService;
import order.entity.Order;
import order.mapper.OrderMapper;
import order.repo.OrderRepo;

import org.springframework.stereotype.Service;

/**
 * Service layer responsible for handling business logic related to orders.
 * <p>
 * This class demonstrates object-oriented design principles by separating
 * business logic from controllers and data storage layers.
 * Responsibilities include:
 * <ul>
 *     <li>Generating a unique order ID</li>
 *     <li>Converting DTOs to Entities</li>
 *     <li>Saving orders to the repository</li>
 *     <li>Returning DTOs back to the controller</li>
 * </ul>
 */

@Service
public class OrderService {

  private final OrderRepo orderRepo;
  private final SequenceGenerator sequenceGenerator;

  /**
   * Constructs a new OrderService with required dependencies.
   *
   * @param orderRepo         repository for saving and retrieving orders
   * @param sequenceGenerator component responsible for generating order IDs
   */
  public OrderService(OrderRepo orderRepo, SequenceGenerator sequenceGenerator) {
    this.orderRepo = orderRepo;
    this.sequenceGenerator = sequenceGenerator;
  }

  /**
   * Saves a new order in the system based on the data submitted from the front-end.
   * <p>
   * Steps:
   * <ol>
   *     <li>Generate a unique Order ID</li>
   *     <li>Convert DTO from FE → Entity</li>
   *     <li>Save to repository</li>
   *     <li>Convert Entity → DTO for controller response</li>
   * </ol>
   *
   * @param orderDetails DTO containing user-submitted order information
   * @return OrderDTO representation of the saved order
   */
  public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {

    int newOrderId = sequenceGenerator.generateNextOrderId();

    // Convert FE DTO → Entity
    Order orderToSave = OrderMapper.mapDTOFromFEToOrder(orderDetails, newOrderId);

    // Save entity
    orderRepo.save(orderToSave);

    // Convert Entity → DTO for returning to controller
    return OrderMapper.mapOrderToOrderDTO(orderToSave);
  }
}

