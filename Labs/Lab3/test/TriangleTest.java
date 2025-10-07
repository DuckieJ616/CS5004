import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  @Test
  void constructor_allDistinct_ok() {
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(new Point2D(0, 0), t.getP1());
    assertEquals(new Point2D(3, 0), t.getP2());
    assertEquals(new Point2D(0, 4), t.getP3());
  }

  @Test
  void constructor_duplicatePoints_throw() {
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(0, 0, 0, 0, 1, 0));
    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(new Point2D(0, 0), new Point2D(1, 1), new Point2D(1, 1)));
  }

  @Test
  void perimeter_rightTriangle345_is12() {
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(12.0, t.perimeter(), 1e-9);
    assertTrue(t.perimeter() > 0);
  }

  @Test
  void area_rightTriangle345_is6() {
    Triangle t = new Triangle(0, 0, 3, 0, 0, 4);
    assertEquals(6.0, t.area(), 1e-9);
    assertTrue(t.area() > 0);
  }

  @Test
  void area_collinear_isZero_andPerimeterPositive() {
    Triangle t = new Triangle(0, 0, 1, 1, 2, 2);
    assertEquals(0.0, t.area(), 1e-9);
    assertTrue(t.perimeter() > 0, "共线但周长应大于 0");
  }

  @Test
  void move_returnsNew_preservesAreaPerimeter() {
    Triangle t1 = new Triangle(0, 0, 3, 0, 0, 4);
    Shape moved = t1.move(1, -2);
    assertNotSame(t1, moved);
    Triangle t2 = (Triangle) moved;

    assertEquals(new Point2D(1, -2), t2.getP1());
    assertEquals(new Point2D(4, -2), t2.getP2());
    assertEquals(new Point2D(1,  2), t2.getP3());

    assertEquals(t1.area(), t2.area(), 1e-9);
    assertEquals(t1.perimeter(), t2.perimeter(), 1e-9);
  }

  @Test
  void toString_containsAllPoints() {
    Triangle t = new Triangle(0, 0, 1, 0, 0, 1);
    String s = t.toString();
    assertTrue(s.contains("Triangle"));
    assertTrue(s.contains("(0.0, 0.0"));
    assertTrue(s.contains("(1.0, 0.0"));
    assertTrue(s.contains("(0.0, 1.0"));
  }

  @Test
  void compareTo_threeOutcomes() {
    Triangle tNear = new Triangle(0, 0,  1, 0,  0, 1); // 距离 0
    Triangle tFar  = new Triangle(2, 0,  3, 0,  2, 1); // 距离 2
    Triangle tEq   = new Triangle(0, 2,  0, 3,  1, 2); // 距离也为 2

    assertTrue(tNear.compareTo(tFar) < 0,  "0 < 2");
    assertEquals(0, tFar.compareTo(tEq),  "2 == 2");
    assertTrue(tFar.compareTo(tNear) > 0, "2 > 0");
  }

  @Test
  void referencePoint_isFirstArg_affectsCompareDistance() {
    Triangle a = new Triangle(0, 0, 4, 0, 0, 3); // ref (0,0) 距离 0
    Triangle b = new Triangle(4, 0, 0, 0, 0, 3); // ref (4,0) 距离 4
    assertTrue(a.compareTo(b) < 0);
    Triangle bShift = (Triangle) b.move(-4, 0);  // ref 变为 (0,0)
    assertEquals(0, bShift.compareTo(a));
  }
}