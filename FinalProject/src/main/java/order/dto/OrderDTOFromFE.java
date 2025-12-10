package order.dto;

import java.util.List;

/**
 * DTO representing the order information submitted by the front-end
 * when a user creates a new order.
 *
 * <p>This object contains only the user-facing fields needed to create
 * an order: the list of food items, the restaurant selected, and the
 * user ID. It excludes internal system details such as the generated
 * orderId, which is handled by the service layer.</p>
 *
 * <p>This class demonstrates object-oriented design by separating
 * input DTOs (data coming from the client) from output DTOs
 * (data returned to the client), helping maintain clean abstractions
 * and separation of concerns.</p>
 */
public class OrderDTOFromFE {

  private List<FoodItemsDTO> foodItemsList;
  private Integer userId;
  private Restaurant restaurant;

  public OrderDTOFromFE() {}

  /**
   * Constructs a new OrderDTOFromFE with all required information.
   *
   * @param foodItemsList list of food items selected by the user
   * @param userId        ID of the user placing the order
   * @param restaurant    restaurant selected for the order
   */
  public OrderDTOFromFE(List<FoodItemsDTO> foodItemsList,
      Integer userId,
      Restaurant restaurant) {
    this.foodItemsList = foodItemsList;
    this.userId = userId;
    this.restaurant = restaurant;
  }

  // Getters and Setters

  public List<FoodItemsDTO> getFoodItemsList() {
    return foodItemsList;
  }

  public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
    this.foodItemsList = foodItemsList;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }
}

