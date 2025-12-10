package order.controller;

import order.dto.OrderDTO;
import order.dto.OrderDTOFromFE;
import order.service.OrderService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Controller responsible for handling incoming order-related
 * requests. This layer receives data from the client,
 * delegates processing to the service layer, and returns
 * the appropriate responses.
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  /**
   * Accepts an order from the UI, forwards it to the
   * service layer for processing, and returns the saved order.
   *
   * @param orderDetails Order details submitted from the UI
   * @return ResponseEntity containing the saved order DTO
   */
  @PostMapping("/saveOrder")
  public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
    OrderDTO orderSavedInDB = orderService.saveOrderInDb(orderDetails);
    return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
  }
}
