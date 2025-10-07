public abstract class AbstractShape implements Shape {
  private final Point2D referencePoint;

  public AbstractShape(Point2D referencePoint) {
    this.referencePoint = referencePoint;
  }

  @Override
  public Point2D getReferencePoint() {
    return referencePoint;
  }

  @Override
  public int compareTo(Shape other) {
    return Double.compare(
        this.referencePoint.distanceFromOrigin(),
        other.getReferencePoint().distanceFromOrigin()
    );
  }

  @Override
  public String toString() {
    return "AbstractShape at " + referencePoint;
  }
}
