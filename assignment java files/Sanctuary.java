import java.util.ArrayList;

/**
 * Manages a collection of animals at a single location.
 */
public class Sanctuary {

    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;


    public Sanctuary(String name, String island, int capacity) {
        this.name = name;
        this.island = island;
        this.capacity = capacity;
        this.animals = new ArrayList<Animal>();
    }

    public String getName() {
        return this.name;
    }

    public String getIsland() {
        return this.island;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    /**
     * Adds an animal to this sanctuary.
     * Rejects null animals, rejects if at capacity, rejects if animal's island
     * does not match this sanctuary's island.
     */
    public boolean addAnimal(Animal a) {
        if(a == null) {
            return false;
        }
        if(animals.size() >= capacity) {
            return false;
        }
        if(!a.getIsland().equals(this.island)) {
            return false;
        }
        animals.add(a);
        return true;
    }

    /**
     * Removes and returns the animal with the given ID, or null if not found.
     *
     */
    public Animal removeAnimal(int animalId) {
        for(Animal a : animals) {
            if(a.getAnimalId() == animalId) {
                animals.remove(a);
                return a;
            }
        }
        return null;
    }


    public int getAnimalCount() {
        return animals.size();
    }

    /**
     * Returns a new ArrayList containing only animals of the given type.
     */
    public ArrayList<Animal> getAnimalsOfType(String type) {
        ArrayList <Animal> result = new ArrayList<>();
        for(Animal a : animals) {
            if(a.getType().equals(type)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Returns the total daily food cost for all animals, rounded to 2 decimal places.
     */
    public double getDailyFoodBudget() {
        double foodBudget = 0.0;
        for(Animal a : animals) {
            foodBudget += a.getDailyFoodCostTTD();
        }
        return Math.round(foodBudget * 100.0) / 100.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        ArrayList<Animal> result = new ArrayList<>();
        for(Animal a : animals) {
            if(a instanceof Relocatable) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Returns the animal with the highest daily food cost, or null if empty.
     *
     */
    public Animal getMostExpensiveAnimal() {
        if(animals.isEmpty()) {
            return null;
        }
        Animal mostExpensiveAnimal = animals.get(0);
        for(Animal a : animals) {
            if(a.getDailyFoodCostTTD() > mostExpensiveAnimal.getDailyFoodCostTTD()) {
                mostExpensiveAnimal = a;
            }
        }
        return mostExpensiveAnimal;
    }

    /**
     * Transfers an animal to another sanctuary.
     * If the animal does not implement Relocatable, the transfer fails:
     * re-add the animal to this sanctuary and return false.
     * Otherwise, call relocateTo on the animal, then addAnimal on target.
     *
     */
    public boolean transferAnimal(int animalId, Sanctuary target) {
        Animal targetAnimal = removeAnimal(animalId);
        if(targetAnimal == null) {
            return false;
        }
        if(!(targetAnimal instanceof Relocatable)) {
            animals.add(targetAnimal);
            return false;
        }
        Relocatable targetRelocatable = (Relocatable) targetAnimal;
        String originalIsland = targetAnimal.getIsland();
        targetRelocatable.relocateTo(target.getIsland());
        boolean addAnimalResult = target.addAnimal(targetAnimal);
        if(!addAnimalResult) {
            targetRelocatable.relocateTo(this.getIsland());
            animals.add(targetAnimal);
            return false;
        }
        return true;
    }

    /**
     * Prints each animal's toString, indented by 2 spaces.
     *
     */
    public void printRoster() {
        for(Animal a : animals) {
            System.out.println("  " + a.toString());
        }
    }

    /**
     * Format: "Name (Island) [count/capacity animals]"
     * Example: "Caroni Bird Sanctuary (Trinidad) [12/50 animals]"
     *
     */
    @Override
    public String toString() {
        return String.format("%s (%s) [%d/%d animals]", name, island, animals.size(), capacity);
    }
}
