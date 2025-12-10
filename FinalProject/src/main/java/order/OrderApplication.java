package order;

import order.service.SequenceGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main entry point of the Order Service application.
 *
 * <p>This class bootstraps and starts the Spring Boot application.
 * It also exposes commonly needed beans such as {@link SequenceGenerator},
 * allowing them to be injected across the system.</p>
 *
 * <p>Centralizing configuration here improves modularity and demonstrates
 * key object-oriented design principles such as abstraction and dependency injection.</p>
 */
@SpringBootApplication
public class OrderApplication {

  /**
   * Starts the Spring Boot application.
   *
   * @param args CLI arguments passed during application startup
   */
  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }

  /**
   * Registers a {@link SequenceGenerator} bean for creating unique order IDs.
   *
   * @return a new SequenceGenerator instance
   */
  @Bean
  public SequenceGenerator sequenceGenerator() {
    return new SequenceGenerator();
  }
}
