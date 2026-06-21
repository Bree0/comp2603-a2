/**
 * Marine subclass. Implements Trackable and Relocatable.
 */
public class Marine extends Animal implements Trackable , Relocatable  {

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
    @Override
    public void logSighting(String date, String location){
        getSightings().add(date + " at "  + location);
    }


    @Override
    public int getSightingCount() {
        return getSightings().size();
    }


    @Override
    public String getLastSighting(){
        if(getSightings().isEmpty()){
            return "No sightings recorded";
        }
        return getSightings().get(getSightings().size() - 1);
    }

    // --- Relocatable methods ---
    @Override
    public boolean canRelocateTo(String targetIsland){
        return !targetIsland.equals(getIsland());
    }


    @Override
    public double getRelocationCost(){
        return 2000.0 + tankSizeLitres * 5.0;
    }

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland
    @Override
    public void relocateTo(String island){
        setIsland(island);
    }
}
