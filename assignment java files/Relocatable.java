/**
 * Relocatable interface for animals that can be transferred between islands.
 *
 */
public interface Relocatable {
    boolean canRelocateTo(String targetIsland);
    double getRelocationCost();
    void relocateTo(String island);
}
