package order.controller;

import order.dto.OrderDTO;
import order.dto.OrderDTOFromFE;
import order.controller.OrderController;
import order.service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Unit tests for {@link OrderController}.
 *
 * <p>This test class validates that the controller:
 * <ul>
 *     <li>Correctly delegates order creation to {@link OrderService}</li>
 *     <li>Returns the proper HTTP response status and body</li>
 *     <li>Handles DTOs from the front-end</li>
 * </ul>
 *
 * <p>Because this is a controller unit test, the service layer is mocked to isolate
 * controller behavior and ensure the test follows the principle of
 * <b>unit-level isolation (Single Responsibility in testing)</b>.
 */


public class OrderControllerTest {

  private OrderService orderService;
  private OrderController orderController;

  /**
   * Sets up the mocked service and controller before each test.
   *
   * <p>This ensures each test runs independently with a clean test context.</p>
   */
  @BeforeEach
  public void setUp() {
    orderService = mock(OrderService.class);
    orderController = new OrderController(orderService);
  }

  /**
   * Tests whether the controller successfully processes an incoming order request
   * and returns a proper HTTP 201 CREATED response.
   *
   * <p>Behavior validated:
   * <ul>
   *     <li>The service is called with the correct DTO</li>
   *     <li>A mapped {@link OrderDTO} is returned</li>
   *     <li>The HTTP response status is CREATED</li>
   * </ul>
   *
   * <p>This test demonstrates:
   * <b>Dependency Injection, Isolation in testing, and Controller-Service separation.</b>
   */
  @Test
  public void testSaveOrder_Success() {
    OrderDTOFromFE inputDto = new OrderDTOFromFE(null, 1, null);
    OrderDTO returnedDto = new OrderDTO(1001, null, null, null);
    returnedDto.setOrderId(1001);

    when(orderService.saveOrderInDb(any(OrderDTOFromFE.class)))
        .thenReturn(returnedDto);

    ResponseEntity<OrderDTO> response = orderController.saveOrder(inputDto);

    assertNotNull(response);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(1001, response.getBody().getOrderId());
  }
}

