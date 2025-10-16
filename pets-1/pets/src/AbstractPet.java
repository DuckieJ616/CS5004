/**
 * Abstract base class for all pets types in the pet management system
 * Implements common pet attributes and behaviors shared across different pet species.
 * Provides base implementation of the Pet interface and Comparable for natural ordering.
 * Subclasses include Dog, Cat, Bird, and Fish which extend this base functionality.
 *
 */
public abstract class AbstractPet implements Pet, Comparable<Pet> {
    protected String name;
    protected int age;
    protected double weight;
    protected int adoptionDate;
    protected String owner;
    protected Color color;
    protected int lastVetVisit;
    
    /**
     * 
     */
    public AbstractPet(String name, int age, double weight, int adoptionDate,
        String owner, Color color, int lastVetVisit) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.adoptionDate = adoptionDate;
        this.owner = owner;
        this.color = color;
        /** Bug 1
         *  lastVetVisit parameter is missing
         *  approach: Add assignment statement for lastVetVisit field
         **/
        this.lastVetVisit = lastVetVisit;
    }

    /**
     * 
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * 
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * 
     */
    @Override
    public double getWeight() {
        return weight;
    }
    
    /**
     * 
     */
    @Override
    public String getOwner() {
        return owner;
    }
    
    /**
     * 
     */
    @Override
    public Color getColor() {
        return color;
    }
    
    /**
     * 
     */
    @Override
    public int getLastVetVisit() {
        return lastVetVisit;
    }

    /**
     * Returns a string representation of the pet
     */
    @Override
    public String toString(){
        return "Pet[name=" + name + ", age=" + age + ", weight=" + weight +
            ", owner=" + owner + ", color=" + color + ", lastVetVisit=" + lastVetVisit + "]";
    }
    
    /**
     * Default "natural"/Comparable method for comparing pets
     * <p>
     * A heavy pet is "greater than" a lighter pet, based on their weight
     * Originally provided code is just a placeholder
     */
    public int compareTo(Pet other) {
        if (this.weight > other.getWeight()) return 1;
        if (this.weight < other.getWeight()) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        AbstractPet other = (AbstractPet) obj;

        if (age != other.age) return false;
        if (Double.compare(weight, other.weight) != 0) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (owner == null) {
            if (other.owner != null) return false;
        } else if (!owner.equals(other.owner)) {
            return false;
        }
        if (color != other.color) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        long temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

}
