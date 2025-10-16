import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AbstractPet methods.
 * Contains two assertions for each method.
 *
 */
public class AbstractPetTest {

    private Pet dog;
    private Pet cat;
    private Pet bird;
    /**
     * 
     */
    @BeforeEach
    public void setUp() {
        dog = new Dog("Wolf", 3, 45.0, 2022, "Alice", Color.BROWN, 2025, "Retriever", true, 45);
        cat = new Cat("Mimi", 2, 8.5, 2023, "Bob", Color.GRAY, 2024, true, false, "long");
        bird = new Bird("Sing", 1, 0.5, 2024, "Carol", Color.YELLOW, 2025, "Canary", 6.0, true, 12);
        
    }
    
    /**
     * 
     */
    @Test
    public void testGetName() {
        assertEquals("Wolf", dog.getName());
        assertEquals("Mimi", cat.getName());
    }
    
    /**
     * 
     */
    @Test
    public void testGetAge() {
        assertEquals(3, dog.getAge());
        assertEquals(1, bird.getAge());
    }
    
    /**
     * 
     */
    @Test
    public void testGetWeight() {
        assertEquals(45.0, dog.getWeight(), 0.001);
        assertEquals(8.5, cat.getWeight(), 0.001);
    }
    
    /**
     * 
     */
    @Test
    public void testGetOwner() {
        assertEquals("Alice", dog.getOwner());
        assertEquals("Bob", cat.getOwner());
    }
    
    /**
     * 
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.BROWN, dog.getColor());
        assertEquals(Color.GRAY, cat.getColor());
    }


    /**
     * 
     */
    @Test
    public void testGetLastVetVisit() {
        assertEquals(2025, dog.getLastVetVisit());
        assertEquals(2024, cat.getLastVetVisit());
    }
    
    /**
     * 
     */
    @Test
    public void testToString() {
        String dogString = dog.toString();
        assertTrue(dogString.contains("Wolf"));
        assertTrue(dogString.contains("45.0"));
    }
    
    /**
     * 
     */
    @Test
    public void testCompareTo() {
        assertTrue(dog.compareTo(cat) > 0);
        assertTrue(cat.compareTo(dog) < 0);
    }
}
