public class Cat {
  private final String name;
  private int age;
  private final CatColor color;
  private Person owner;

  /**
   * Constructs a Cat with all required fields.
   * @param name the cat's name
   * @param age the cat's age
   * @param color the cat's color
   * @param owner the cat's owner
   */
  public Cat(String name, int age, CatColor color, Person owner) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.owner = owner;
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public CatColor getColor() { return color; }

  public Person getOwner() { return owner; }

  public void setAge(int age) { this.age = age; }

  public void setOwner(Person owner) { this.owner = owner; }

  @Override
  public String toString() {
    return "Cat{name='" + name + "', age=" + age +
        ", color=" + color + ", owner=" + owner + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cat)) return false;
    Cat cat = (Cat) o;
    return age == cat.age &&
        name.equals(cat.name) &&
        color == cat.color &&
        ((owner == null && cat.owner == null) || (owner != null && owner.equals(cat.owner)));
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + age;
    result = 31 * result + color.hashCode();
    result = 31 * result + (owner != null ? owner.hashCode() : 0);
    return result;
  }
}
