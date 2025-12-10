package order.repo;

import order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class that simulates data persistence for Order objects.
 * <p>
 * Instead of connecting to a real database, this repository maintains
 * an in-memory list of Order entities. This keeps the project
 * self-contained and fully aligned with the CS5004 Final Project
 * requirements, while still demonstrating the Repository pattern and
 * separation of concerns.
 */
@Repository
public class OrderRepo {

  private final List<Order> database = new ArrayList<>();

  /**
   * Saves an Order entity into the in-memory list.
   *
   * @param order the order to be stored
   */
  public void save(Order order) {
    database.add(order);
  }

  /**
   * Retrieves all stored orders.
   *
   * @return a list of all orders saved so far
   */
  public List<Order> findAll() {
    return new ArrayList<>(database);
  }
}

