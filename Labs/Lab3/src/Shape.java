public interface Shape extends Comparable<Shape> {
  double area();
  double perimeter();
  Point2D getReferencePoint();
  Shape move(double dx, double dy);
}
