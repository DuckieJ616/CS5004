package order.dto;

/**
 * Represents a food item included in an order.
 * <p>
 * This DTO holds information such as item name, description,
 * vegetarian status, price, and quantity. It is used to transfer
 * food item data between layers without exposing internal logic
 * or database structures.
 * <p>
 * This class demonstrates OOD principles including encapsulation
 * through the use of private fields and public getters/setters.
 */
public class FoodItemsDTO {

  private int id;
  private String itemName;
  private String itemDescription;
  private boolean isVeg;
  private Long price;
  private Integer restaurantId;
  private Integer quantity;

  public FoodItemsDTO() {}
  /**
   * Constructs a FoodItemsDTO with all required information.
   *
   * @param id             unique identifier for the food item
   * @param itemName       name of the food item
   * @param itemDescription description of the item
   * @param isVeg          whether the item is vegetarian
   * @param price          price of the item
   * @param restaurantId   ID of the restaurant providing this item
   * @param quantity       quantity ordered
   */

  public FoodItemsDTO(int id, String itemName, String itemDescription,
      boolean isVeg, Long price, Integer restaurantId,
      Integer quantity) {
    this.id = id;
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.isVeg = isVeg;
    this.price = price;
    this.restaurantId = restaurantId;
    this.quantity = quantity;
  }

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public boolean isVeg() {
    return isVeg;
  }

  public void setVeg(boolean veg) {
    isVeg = veg;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Integer getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Integer restaurantId) {
    this.restaurantId = restaurantId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}

