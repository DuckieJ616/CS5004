public class Shoe {
  private final Kind kind;
  private final Color color;
  private final Brand brand;
  private final double size;

  /**
   * Creates a new {@code Shoe} instance.
   *
   * @param kind  the kind of shoe (e.g., SNEAKER, DRESS)
   * @param color the color (e.g., BLACK, PASTEL)
   * @param brand the brand (e.g., NIKE, ADIDAS)
   * @param size  the size (e.g., 8.5)
   * @throws IllegalArgumentException if {@code brand == NIKE && kind == DRESS}
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("NIKE brand cannot be DRESS kind");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  public Kind getKind() { return kind; }

  public Color getColor() { return color; }

  public Brand getBrand() { return brand; }

  public double getSize() { return size; }


  @Override
  public String toString() {
    String brandStr = switch (brand) {
      case NIKE -> "Nike";
      case ADIDAS -> "adidas";
      case PUMA -> "Puma";
      case NEW_BALANCE -> "New Balance";
    };

    String kindStr = switch (kind) {
      case SNEAKER -> "sneaker";
      case DRESS -> "dress shoe";
      case BOOT -> "Boot";
      case SANDAL -> "sandal";
    };

    String colorStr = switch (color) {
      case BLACK -> "Black";
      case WHITE -> "White";
      case RED -> "Red";
      case BLUE -> "Blue";
      case NEUTRAL -> "Neutral";
    };

    return String.format("%s %s (%s, %.1f)", brandStr, kindStr, colorStr, size);
  }
}
