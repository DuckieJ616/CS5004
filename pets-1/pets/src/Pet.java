/**
 * This interface describes what every pet in our system should be able to do.
 * Pets can be compared to each other (using their natural order) since it extends Comparable.
 * It defines the basic info of pets, like name, age, weight, and owner,
 * as well as common behaviors (feeding, making sounds), exercise needs, and health tracking.
 */
public interface Pet extends Comparable<Pet> {

    /**
     *
     */
    String getName();

    /**
     *
     */
    int getAge();

    /**
     *
     */
    double getWeight();

    /**
     *
     */
    String getOwner();

    /**
     *
     */
    void feed();

    /**
     *
     */
    Color getColor();

    /**
     *
     */
    String getExerciseNeeds();

    /**
     *
     */
    String makeSound();

    /**
     *
     */
    int getLifespan();
    /**
     *
     */
    int getLastVetVisit();
}