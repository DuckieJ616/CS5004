import java.util.Comparator;

/**
 * A Comparator that sorts pets by the date of their last vet visit.
 * Pets that went to the vet earlier will show up first.
 * You can plug this into Collections.sort() when you want this custom order.
 */
public class PetLastVetVisitComparator implements Comparator<Pet> {
    
    /**
     * An alternative comparison based on Lifespan.
     */
    @Override
    public int compare(Pet pet1, Pet pet2) {
        //BUG 4
        //Issue: Variables declared as double but getLastVetVisit() returns int
        //Approach: Change variable type from double to int
        //Solution: change double to int
        int w1 = pet1.getLastVetVisit();
        int w2 = pet2.getLastVetVisit();
        //BUG 5
        //Issue: Method returns -1 when w1 < w2, but should return 1 when w1 > w2
        //Approach: Add the w1 > w2 condition
        //Solution: Add return 1 when w1 > w2
        if (w1 < w2) return -1;
        if (w1 > w2) return 1;
        return 0;
    }
}
