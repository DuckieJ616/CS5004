package order.entity;

import order.dto.FoodItemsDTO;
import order.dto.Restaurant;
import order.dto.UserDTO;

import java.util.List;
/**
 * Represents an Order placed by a user in the system.
 * <p>
 * This entity stores the core information about a single order,
 * including the order ID, list of food items, restaurant details,
 * and (optionally) the user who placed the order.
 * <p>
 * This class showcases object-oriented design through encapsulation
 * and composition, as an Order is composed of multiple other domain
 * objects such as FoodItemsDTO and Restaurant.
 */
public class Order {

  private Integer orderId;
  private List<FoodItemsDTO> foodItemsList;
  private Restaurant restaurant;
  private UserDTO userDTO;

  /**
   * Builds a new Order object with the specified details.
   *
   * @param orderId        unique identifier assigned to the order
   * @param foodItemsList  list of food items included in the order
   * @param restaurant     restaurant from which the order is placed
   * @param userDTO        details of the user placing the order
   */
  public Order(Integer orderId,
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

