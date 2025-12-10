package order.dto;

/**
 * Represents a restaurant from which the user can place an order.
 * <p>
 * This DTO contains information such as the restaurant's name,
 * address, and description. It is used within the order module
 * to associate an order with a specific restaurant.
 * <p>
 * The class demonstrates encapsulation through private fields
 * and public accessor methods.
 */
public class Restaurant {

  private int id;
  private String name;
  private String address;
  private String city;
  private String restaurantDescription;

  public Restaurant() { }
  /**
   * Constructs a new Restaurant object with the provided details.
   *
   * @param id                    unique identifier for the restaurant
   * @param name                  restaurant name
   * @param address               physical address of the restaurant
   * @param city                  city in which the restaurant is located
   * @param restaurantDescription brief description of the restaurant
   */
  public Restaurant(int id,
      String name,
      String address,
      String city,
      String restaurantDescription) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.city = city;
    this.restaurantDescription = restaurantDescription;
  }

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getRestaurantDescription() {
    return restaurantDescription;
  }

  public void setRestaurantDescription(String restaurantDescription) {
    this.restaurantDescription = restaurantDescription;
  }
}

