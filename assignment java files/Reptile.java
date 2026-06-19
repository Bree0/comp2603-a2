/**
 * Reptile subclass. Implements Trackable but NOT Relocatable.
 *
 */
public class Reptile extends Animal implements Trackable {

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
}
