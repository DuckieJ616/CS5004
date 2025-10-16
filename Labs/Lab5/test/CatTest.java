import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

  @Test
  public void testSetters() {
    Person owner1 = new Person("Alice");
    Cat cat = new Cat("Whiskers", 3, CatColor.BLACK, owner1);

    cat.setAge(4);
    assertEquals(4, cat.getAge());

    Person owner2 = new Person("Bob");
    cat.setOwner(owner2);
    assertEquals(owner2, cat.getOwner());
  }

  @Test
  public void testEqualsPositive() {
    Person owner = new Person("Charlie");
    Cat cat1 = new Cat("Mittens", 2, CatColor.WHITE, owner);
    Cat cat2 = new Cat("Mittens", 2, CatColor.WHITE, new Person("Charlie"));

    assertEquals(cat1, cat2);
  }

  @Test
  public void testEqualsNegativeDifferentName() {
    Person owner = new Person("Dana");
    Cat cat1 = new Cat("Snowball", 1, CatColor.ORANGE, owner);
    Cat cat2 = new Cat("Fluffy", 1, CatColor.ORANGE, owner);

    assertNotEquals(cat1, cat2);
  }

  @Test
  public void testHashCodeConsistency() {
    Person owner = new Person("Eve");
    Cat cat1 = new Cat("Tiger", 5, CatColor.TABBY, owner);
    Cat cat2 = new Cat("Tiger", 5, CatColor.TABBY, new Person("Eve"));

    assertEquals(cat1.hashCode(), cat2.hashCode());
  }

  @Test
  public void testHashCodeUsuallyDifferent() {
    Person owner = new Person("Frank");
    Cat cat1 = new Cat("Bella", 3, CatColor.CALICO, owner);
    Cat cat2 = new Cat("Luna", 4, CatColor.GRAY, owner);

    assertNotEquals(cat1.hashCode(), cat2.hashCode());
  }
}