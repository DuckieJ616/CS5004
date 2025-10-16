public class Person {
  private final String id;

  /**
   * Constructs a Person with the given id.
   * @param id unique identifier for the person
   */
  public Person(String id) {
    this.id = id;
  }

  /**
   * Gets the id of this person.
   * @return the id
   */
  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Person{id='" + id + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return id != null && id.equals(person.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
