import java.util.Objects;

public class Triangle extends AbstractShape {
  private final Point2D p2;
  private final Point2D p3;

  public Triangle(double x1, double y1,
      double x2, double y2,
      double x3, double y3) {
    this(new Point2D(x1, y1), new Point2D(x2, y2), new Point2D(x3, y3));
  }

  public Triangle(Point2D p1, Point2D p2, Point2D p3) {
    super(validateDistinct(p1, p2, p3)[0]);
    this.p2 = validateDistinct(p1, p2, p3)[1];
    this.p3 = validateDistinct(p1, p2, p3)[2];
  }

  private static Point2D[] validateDistinct(Point2D p1, Point2D p2, Point2D p3) {
    if (p1 == null || p2 == null || p3 == null) {
      throw new IllegalArgumentException("Points cannot be null");
    }
    if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
      throw new IllegalArgumentException("Triangle points must be distinct");
    }
    return new Point2D[]{p1, p2, p3};
  }

  public Point2D getP1() { return getReferencePoint(); }
  public Point2D getP2() { return p2; }
  public Point2D getP3() { return p3; }

  @Override
  public double perimeter() {
    double a = getReferencePoint().distanceTo(p2);
    double b = p2.distanceTo(p3);
    double c = p3.distanceTo(getReferencePoint());
    return a + b + c;
  }

  @Override
  public double area() {
    double a = getReferencePoint().distanceTo(p2);
    double b = p2.distanceTo(p3);
    double c = p3.distanceTo(getReferencePoint());
    double s = (a + b + c) / 2.0;
    double value = s * (s - a) * (s - b) * (s - c);
    if (value <= 0) return 0.0;
    return Math.sqrt(value);
  }

  @Override
  public Shape move(double dx, double dy) {
    Point2D np1 = getReferencePoint().move(dx, dy);
    Point2D np2 = p2.move(dx, dy);
    Point2D np3 = p3.move(dx, dy);
    return new Triangle(np1, np2, np3);
  }

  @Override
  public String toString() {
    return String.format("Triangle{p1=%s, p2=%s, p3=%s}",
        getReferencePoint(), p2, p3);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Triangle)) return false;
    Triangle t = (Triangle) o;
    return getReferencePoint().equals(t.getReferencePoint())
        && p2.equals(t.p2) && p3.equals(t.p3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getReferencePoint(), p2, p3);
  }
}
