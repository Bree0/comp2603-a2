import java.util.ArrayList;

/**
 * Console-based demonstration of the Caribbean Wildlife Conservation Tracker.
 * Creates sanctuaries, adds animals, and exercises all major features.
 *
 * TODO M9: Implement the entire Driver class
 *
 * See the README for the complete expected output.
 */
public class Driver {
    public static void main(String[] args) {


        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Sanctuary bluelagoon = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);


        Bird ruby = new Bird ("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas);


        Bird flash = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
        Marine shelly = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        Marine gills = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);

        bluelagoon.addAnimal(flash);
        bluelagoon.addAnimal(shelly);
        bluelagoon.addAnimal(gills);


        System.out.println("=== Caroni Bird Sanctuary roster ===");
        caroni.printRoster();
        System.out.println();


        System.out.println("=== Blue Lagoon Marine Park roster ===");
        bluelagoon.printRoster();
        System.out.println();


        System.out.println("=== Daily food budgets ===");
        System.out.println(caroni.getName() + ": $" + String.format("%.2f", caroni.getDailyFoodBudget()) + " TTD");
        System.out.println(bluelagoon.getName() + ": $" + String.format("%.2f", bluelagoon.getDailyFoodBudget()) + " TTD");
        System.out.println();


        System.out.println("=== Birds at Caroni ===");
        for (Animal a : caroni.getAnimalsOfType("Bird")) {
            System.out.println("  " + a.toString());
        }
        System.out.println();


        System.out.println("=== Relocatable animals at Caroni ===");
        for (Animal a : caroni.getRelocatableAnimals()) {
            System.out.println("  " + a.toString());
        }
        System.out.println();


        System.out.println("=== Sighting logs ===");
        ruby.logSighting("2026-06-10", "Caroni Swamp");
        ruby.logSighting("2026-06-12", "Nariva Swamp");
        atlas.logSighting("2026-06-11", "Matura Beach");
        System.out.println("Ruby sighting count: " + ruby.getSightingCount());
        System.out.println("Ruby last sighting: " + ruby.getLastSighting());
        System.out.println("Atlas sighting count: " + atlas.getSightingCount());
        System.out.println("Atlas last sighting: " + atlas.getLastSighting());
        System.out.println("Brutus last sighting: " + brutus.getLastSighting());
        System.out.println();


        System.out.println("=== Transfer Atlas to Blue Lagoon ===");
        boolean atlasTransfer = caroni.transferAnimal(atlas.getAnimalId(), bluelagoon);
        System.out.println("Transfer successful: " + atlasTransfer);
        System.out.println("Blue Lagoon Marine Park roster after transfer:");
        bluelagoon.printRoster();
        System.out.println();


        System.out.println("=== Attempt to transfer Brutus (Reptile) ===");
        boolean brutusTransfer = caroni.transferAnimal(brutus.getAnimalId(), bluelagoon);
        System.out.println("Transfer successful: " + brutusTransfer);
        System.out.println();


        System.out.println("=== Most expensive animal at each sanctuary ===");
        Animal caroniExpensive = caroni.getMostExpensiveAnimal();
        Animal blueLagoonExpensive = bluelagoon.getMostExpensiveAnimal();
        System.out.println("Caroni: " + caroniExpensive.toString() + " ($" + String.format("%.2f", caroniExpensive.getDailyFoodCostTTD()) + " TTD/day)");
        System.out.println("Blue Lagoon: " + blueLagoonExpensive.toString() + " ($" + String.format("%.2f", blueLagoonExpensive.getDailyFoodCostTTD()) + " TTD/day)");
        System.out.println();


        System.out.println("=== Updated food budgets ===");
        System.out.println(caroni.getName() + ": $" + String.format("%.2f", caroni.getDailyFoodBudget()) + " TTD");
        System.out.println(bluelagoon.getName() + ": $" + String.format("%.2f", bluelagoon.getDailyFoodBudget()) + " TTD");
    }
}
