/**
 * Bird subclass. Implements Trackable and Relocatable.
 *
 * TODO M2: Make this class extend Animal
 * TODO M3: Make this class implement Trackable and Relocatable
 */
public class Bird extends Animal /* TODO M3: implements Trackable, Relocatable */ {

    private double wingspanCm;
    private boolean canFly;
    /**
     * Constructor.
     */
    public Bird(String species, String nickname, String island, double weightKg, String healthStatus,
                double wingspanCm, boolean canFly) {
        super(species, nickname, island, weightKg, healthStatus);
        this.wingspanCm = wingspanCm;
        this.canFly = canFly;
    }

    public double getWingspanCm() {
        return this.wingspanCm;
    }

    public boolean canFly() {
        return this.canFly;
    }


    @Override
    public String getType() {
        return "Bird";
    }

    /**
     * Daily food cost = 15.0 + weightKg * 50.0
     * TODO M2: Implement getDailyFoodCostTTD()
     */
    @Override
    public double getDailyFoodCostTTD() {
        return 15.0 + getWeightKg() * 50.0;
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)
    //          Appends "date at location" to the sightings list

    // TODO M4: Implement getSightingCount()
    //          Returns the size of the sightings list

    // TODO M4: Implement getLastSighting()
    //          Returns the last entry, or "No sightings recorded" if empty

    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    //          Birds can always be relocated; return true

    // TODO M6: Implement getRelocationCost()
    //          Returns 500.0 + weightKg * 100.0

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland()
}
