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

        Bird m4 = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);

        m4.logSighting("2026-06-10", "Caroni Swamp");
        System.out.println(m4.getSightingCount());
        System.out.println(m4.getLastSighting());

        Bird m45 = new Bird("Cocrico", "Brown", "Tobago", 0.20, "Healthy", 50.0, true);
        System.out.println(m45.getLastSighting());

        Sanctuary s1 = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 6);
        s1.addAnimal(m4);
        s1.addAnimal(m45);

        s1.printRoster();

        Marine marine = new Marine ("Leatherback Turtle", "Atlas", "Jamaica", 500.0, "Healthy", 1200.0, 8000);
        System.out.println(marine.canRelocateTo("Jamaica"));
        System.out.println(m4.canRelocateTo("Jamaica"));

        // TODO M9: Create two sanctuaries:
        //   "Caroni Bird Sanctuary", Trinidad, capacity 20
        //   "Blue Lagoon Marine Park", Jamaica, capacity 15

        // TODO M9: Create and add animals to Caroni:
        //   Bird: "Scarlet Ibis", "Ruby", Trinidad, 0.35, "Healthy", 60.0, true
        //   Bird: "Scarlet Ibis", "Blaze", Trinidad, 0.40, "Healthy", 58.0, true
        //   Bird: "Cocrico", "Dusty", Trinidad, 0.25, "Injured", 30.0, true
        //   Reptile: "Spectacled Caiman", "Brutus", Trinidad, 45.0, "Healthy", false, 180.0
        //   Reptile: "Green Anaconda", "Medusa", Trinidad, 30.0, "Critical", false, 350.0
        //   Marine: "Leatherback Turtle", "Atlas", Trinidad, 500.0, "Healthy", 1200.0, 8000

        // TODO M9: Create and add animals to Blue Lagoon:
        //   Bird: "Doctor Bird", "Flash", Jamaica, 0.01, "Healthy", 12.0, true
        //   Marine: "Hawksbill Turtle", "Shelly", Jamaica, 80.0, "Injured", 50.0, 3000
        //   Marine: "Nurse Shark", "Gills", Jamaica, 110.0, "Healthy", 75.0, 5000

        // TODO M9: Print "=== Caroni Bird Sanctuary roster ===" then printRoster()
        // TODO M9: Print "=== Blue Lagoon Marine Park roster ===" then printRoster()

        // TODO M9: Print "=== Daily food budgets ===" then each sanctuary's budget

        // TODO M9: Print "=== Birds at Caroni ===" then getAnimalsOfType("Bird")

        // TODO M9: Print "=== Relocatable animals at Caroni ===" then getRelocatableAnimals()

        // TODO M9: Print "=== Sighting logs ===" then:
        //   Log Ruby: ("2026-06-10", "Caroni Swamp"), ("2026-06-12", "Nariva Swamp")
        //   Log Atlas: ("2026-06-11", "Matura Beach")
        //   Print counts and last sightings for Ruby, Atlas, and Brutus

        // TODO M9: Print "=== Transfer Atlas to Blue Lagoon ===" then transfer and print result

        // TODO M9: Print "=== Attempt to transfer Brutus (Reptile) ===" then transfer and print result

        // TODO M9: Print "=== Most expensive animal at each sanctuary ==="

        // TODO M9: Print "=== Updated food budgets ==="
    }
}
