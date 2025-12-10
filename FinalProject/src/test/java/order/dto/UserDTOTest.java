package order.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTest {

  @Test
  public void testGettersAndSetters() {
    UserDTO user = new UserDTO();

    user.setUserId(1);
    user.setUserName("Cindy");
    user.setUserPassword("1234");
    user.setAddress("Boston");
    user.setCity("MA");

    assertEquals(1, user.getUserId());
    assertEquals("Cindy", user.getUserName());
    assertEquals("1234", user.getUserPassword());
    assertEquals("Boston", user.getAddress());
    assertEquals("MA", user.getCity());
  }
}

