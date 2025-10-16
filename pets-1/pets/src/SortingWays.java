import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Create multiple Pets and then demonstrate sorting three different ways
 * Natural order (heavier is better than lighter
 * last vet visit (latest is better
 * Sorting by Name (using Comparator.comparing())
 *
 */
public class SortingWays {
  public static void main(String[] args) {
    Pet fido = new Dog("Fido", 1, 50, 2025,
        "Mark", Color.BROWN, 2025, "Mutt", true, 30);
    Pet jake = new Cat("Jake", 4, 16, 2021,
        "Mark", Color.BLACK, 2024, true, false, "long");
    Pet elwood = new Cat("Elwood", 4, 15, 2021,
        "Mark", Color.BLACK, 2025, true, false, "long");
    ArrayList<Pet> pets = new ArrayList<>();
    pets.add(jake);
    pets.add(fido);
    pets.add(elwood);
    // Add additional pets here
    System.out.println("Unsorted ArrayList of Pets:");
    System.out.println(pets);
    // Next is a freebie
    Collections.sort(pets); // Built in compareTo method in AbstractPet

    System.out.println("Sorted by weight");
    System.out.println(pets);

    // Collections.sort(pets, ??? to be finished)
    Collections.sort(pets, new PetLastVetVisitComparator());
    System.out.println("Sorted by LastVetVisit:");
    System.out.println(pets);

    // Collections.sort(pets, ??? to be finished)
    Collections.sort(pets, Comparator.comparing(Pet::getName));
    System.out.println("Sorted by Name");
    System.out.println(pets);
  }
}