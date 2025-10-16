/**
 * Represents a dog pet with characteristics including breed,
 * training status, and daily walking times. Dogs make a "Woof!" sound
 * and can fetch or not. Extends AbstractPet to inherit common pet behaviors.
 */
public class Dog extends AbstractPet {
    private String breed;
    private boolean isTrained;
    private int walkMinutesPerDay;

    //BUG 2
    //Issue: Parameter 'weight' should be double, not int (parent expects double)
    //Approach: Change parameter type from int to double to match parent signature
    //Solution:
    // public Dog(String name, int age, int weight, int adoptionDate, String owner, Color color,  int lastVetVisit,
    public Dog(String name, int age, double weight, int adoptionDate, String owner, Color color,  int lastVetVisit,
        String breed, boolean isTrained, int walkMinutesPerDay) {
        //BUG 3
        //Issue: Constructor doesn't call super() to initialize parent class
        //Approach: Add super() call at the beginning of constructor
        //Solution: add super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        this.breed = breed;
        this.isTrained = isTrained;
        this.walkMinutesPerDay = walkMinutesPerDay;
    }

    /**
     * 
     */
    @Override
    public void feed() {
        System.out.println("Good food!");
    }
    
    /**
     * 
     */
    @Override
    public String getExerciseNeeds() {
        return "";
    }
    
    /**
     * 
     */
    @Override
    public int getLifespan() {
        return 0; // Calculate based on breed
    }
    
    /**
     * 
     */
    @Override
    public String makeSound() {
        return "Woof!";
    }
    
    /**
     * 
     */
    public void fetch() {
        
    }
}
