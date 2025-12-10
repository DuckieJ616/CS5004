package order.dto;

import java.util.List;

/**
 * Data Transfer Object representing an Order returned to the client.
 * <p>
 * This DTO abstracts away internal implementation details of the
 * Order entity and ensures that only the required, structured data
 * is exposed to the outside world (controller or front-end).
 * <p>
 * Using DTOs instead of exposing the entity directly demonstrates
 * important OOD principles such as encapsulation and separation
 * of concerns.
 */
public class OrderDTO {

  private Integer orderId;
  private List<FoodItemsDTO> foodItemsList;
  private Restaurant restaurant;
  private UserDTO userDTO;

  public OrderDTO() {}
  /**
   * Constructs an OrderDTO with the provided order details.
   *
   * @param orderId       the unique ID of the order
   * @param foodItemsList the list of food items in the order
   * @param restaurant    the restaurant from which the order was placed
   * @param userDTO       the user associated with the order
   */
  public OrderDTO(Integer orderId,
      List<FoodItemsDTO> foodItemsList,
      Restaurant restaurant,
      UserDTO userDTO) {
    this.orderId = orderId;
    this.foodItemsList = foodItemsList;
    this.restaurant = restaurant;
    this.userDTO = userDTO;
  }


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public List<FoodItemsDTO> getFoodItemsList() {
    return foodItemsList;
  }

  public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
    this.foodItemsList = foodItemsList;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public UserDTO getUserDTO() {
    return userDTO;
  }

  public void setUserDTO(UserDTO userDTO) {
    this.userDTO = userDTO;
  }
}

