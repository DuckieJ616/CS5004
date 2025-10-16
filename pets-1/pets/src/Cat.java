/**
 * Represents a cat pet with characteristics such as indoor/outdoor status,
 * declawed status, and fur length. Cats make a "Meow" sound and can use a litter box.
 * Extends AbstractPet to inherit common pet behaviors.
 *
 */
public class Cat extends AbstractPet {
    private boolean isIndoor;
    private boolean isDeclawed;
    private String furLength;
    
    /**
     * 
     */
    public Cat(String name, int age, double weight, int adoptionDate,
               String owner, Color color, int lastVetVisit,
               boolean isIndoor, boolean isDeclawed, String furLength) {
        super(name, age, weight, adoptionDate, owner, color, lastVetVisit);
        this.isIndoor = isIndoor;
        this.isDeclawed = isDeclawed;
        this.furLength = furLength;
    }

    /**
     * 
     */
    @Override
    public void feed() {
        
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
    public String makeSound() {
        return "Meow";
    }

    @Override
    public int getLifespan() {
        return 0;
    }

    /**
     * 
     */
    public void useLitterBox() {
        
    }
}
