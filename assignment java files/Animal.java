import java.util.ArrayList;

/**
 * Abstract base class for all animals in the conservation system.
 */
public abstract class Animal {

    private static int nextId = 1;

    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;

    private ArrayList<String> sightings;

    /**
     * Constructor: assigns auto-incremented ID, validates all parameters.
     * Species, nickname, island must not be null or empty.
     * weightKg must be > 0.
     * healthStatus must be "Healthy", "Injured", or "Critical".
     */
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        if(species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be null or empty");
        }
        if(nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("Nickname cannot be null or empty");
        }
        if(island == null || island.trim().isEmpty()) {
            throw new IllegalArgumentException("Island cannot be null or empty");
        }
        if(weightKg <= 0){
            throw new IllegalArgumentException("WeightKg must be greater than 0");
        }
        if(!healthStatus.equals("Healthy") &&  !healthStatus.equals("Injured") && !healthStatus.equals("Critical")) {
            throw new IllegalArgumentException("Health Status must be either Healthy or Injured or Critical");
        }
        this.species = species;
        this.nickname = nickname;
        this.island = island;
        this.weightKg = weightKg;
        this.healthStatus = healthStatus;
        this.animalId = nextId;
        nextId++;

        this.sightings = new ArrayList<String>();

    }


    public int getAnimalId() {
        return this.animalId;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getIsland() {
        return this.island;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }


    public void setIsland(String island) {
        this.island = island;
    }


    protected ArrayList<String> getSightings() {
        return this.sightings;
    }

    /**
     * Updates the health status after validation.
     */
    public void updateHealth(String newStatus) {
        if(!newStatus.equals("Healthy") && !newStatus.equals("Injured") && !newStatus.equals("Critical")) {
            throw new IllegalArgumentException("Health Status must be either Healthy or Injured or Critical");
        }
        this.healthStatus = newStatus;
    }

    /**
     * Returns the animal type: "Bird", "Reptile", or "Marine".
     */
    public abstract String getType();

    /**
     * Returns the daily food cost in TTD. Varies by subclass.
     */
    public abstract double getDailyFoodCostTTD();

    /**
     * Format: "#%03d %s '%s' (%s) [%s] %.2f kg - %s"
     * Example: "#001 Scarlet Ibis 'Ruby' (Trinidad) [Bird] 0.35 kg - Healthy"
     *
     */
    @Override
    public String toString() {
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s", this.animalId, this.species, this.nickname, this.island, getType(), this.weightKg, this.healthStatus);
    }

    /**
     * Two animals are equal if they have the same animalId.
     *
     * TODO M5: Implement equals
     */
    @Override
    public boolean equals(Object obj) {
        // TODO M5: Implement equality by animalId
        return false;
    }

    /**
     * TODO M5: Implement hashCode based on animalId
     */
    @Override
    public int hashCode() {
        // TODO M5: Return hash based on animalId
        return 0;
    }
}
