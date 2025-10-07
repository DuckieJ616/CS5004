import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

  static Stream<Shape> shapesProvider() {
    return Stream.of(
        new Triangle(0, 0, 3, 0, 0, 4)
        // , new Rectangle(0,0,2,3)
        // , new Circle(1,1,2)
    );
  }

  @ParameterizedTest
  @MethodSource("shapesProvider")
  void move_returnsNew_and_preservesMetrics(Shape s) {
    Shape moved = s.move(5, -3);
    assertNotSame(s, moved);
    assertEquals(s.area(), moved.area(), 1e-9);
    assertEquals(s.perimeter(), moved.perimeter(), 1e-9);
  }

  @ParameterizedTest
  @MethodSource("shapesProvider")
  void getReferencePoint_isConsistent(Shape s) {
    Point2D p = s.getReferencePoint();
    assertNotNull(p);
    assertEquals(p, s.getReferencePoint());
  }

  @Test
  void compareTo_threeOutcomes_usingTriangles() {
    Shape a = new Triangle(0, 0, 3, 0, 0, 4);
    Shape b = new Triangle(2, 0, 3, 0, 2, 1);
    Shape c = new Triangle(0, 2, 0, 3, 1, 2);
    assertTrue(a.compareTo(b) < 0);
    assertEquals(0, b.compareTo(c));
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  void compareTo_respects_firstArgument_asReference() {
    Shape s1 = new Triangle(0, 0, 4, 0, 0, 3);
    Shape s2 = new Triangle(4, 0, 0, 0, 0, 3);
    assertTrue(s1.compareTo(s2) < 0);
    Shape s2Shift = s2.move(-4, 0);
    assertEquals(0, s1.compareTo(s2Shift));
  }
}
