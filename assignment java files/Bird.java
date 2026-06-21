/**
 * Bird subclass. Implements Trackable and Relocatable.
 *
 */
public class Bird extends Animal implements Trackable, Relocatable  {

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
     */
    @Override
    public double getDailyFoodCostTTD() {
        return 15.0 + getWeightKg() * 50.0;
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
        return true;
    }


    @Override
    public double getRelocationCost(){
        return 500.0 + getWeightKg() * 100.0;
    }

    @Override
    public void relocateTo(String island){
        setIsland(island);
    }
}
