/**
 * Reptile subclass. Implements Trackable but NOT Relocatable.
 *
 * TODO M3: Make this class implement Trackable
 */
public class Reptile extends Animal /* TODO M3: implements Trackable */ {

    private boolean isVenomous;
    private double lengthCm;

    /**
     * Constructor.
     */
    public Reptile(String species, String nickname, String island, double weightKg, String healthStatus,
                   boolean isVenomous, double lengthCm) {
        super(species, nickname, island, weightKg, healthStatus);
        this.isVenomous = isVenomous;
        this.lengthCm = lengthCm;
    }

    public boolean isVenomous() {
        return this.isVenomous;
    }

    public double getLengthCm() {
        return this.lengthCm;
    }


    @Override
    public String getType() {
        return "Reptile";
    }

    /**
     * Daily food cost = 25.0 + weightKg * 2.0
     */
    public double getDailyFoodCostTTD() {
        return 25.0 + getWeightKg() * 2.0;
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)

    // TODO M4: Implement getSightingCount()

    // TODO M4: Implement getLastSighting()
}
