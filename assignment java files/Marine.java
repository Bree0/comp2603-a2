/**
 * Marine subclass. Implements Trackable and Relocatable.
 */
public class Marine extends Animal implements Trackable, Relocatable {

    private double maxDepthM;
    private int tankSizeLitres;

    /**
     * Constructor.
     */
    public Marine(String species, String nickname, String island, double weightKg, String healthStatus,
                  double maxDepthM, int tankSizeLitres) {
        super(species, nickname, island, weightKg, healthStatus);
        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }


    public double getMaxDepthM() {
        return this.maxDepthM;
    }

    public int getTankSizeLitres() {
        return this.tankSizeLitres;
    }


    @Override
    public String getType() {
        return "Marine";
    }

    /**
     * Daily food cost = 50.0 + weightKg * 3.0
     */
    @Override
    public double getDailyFoodCostTTD() {
        return 50.0 + getWeightKg() * 3.0;
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)

    // TODO M4: Implement getSightingCount()

    // TODO M4: Implement getLastSighting()

    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    //          Returns true only if targetIsland is NOT the animal's current island

    // TODO M6: Implement getRelocationCost()
    //          Returns 2000.0 + tankSizeLitres * 5.0

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland()
}
