package order.dto;

/**
 * Represents a user in the system who places an order.
 * <p>
 * This DTO carries user-related information between different
 * application layers without exposing internal entity logic.
 * <p>
 * This class demonstrates important object-oriented principles,
 * including encapsulation via private fields and public accessors.
 */
public class UserDTO {

  private int userId;
  private String userName;
  private String userPassword;
  private String address;
  private String city;

  public UserDTO() {}

  /**
   * Constructs a new UserDTO with the provided user details.
   *
   * @param userId      the unique identifier for the user
   * @param userName    user's name
   * @param userPassword user's password
   * @param address     user's address
   * @param city        user's city of residence
   */
  public UserDTO(int userId, String userName, String userPassword,
      String address, String city) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.address = address;
    this.city = city;
  }

  // Getters and Setters

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
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
}

