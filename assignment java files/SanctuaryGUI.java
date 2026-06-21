import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Swing GUI for searching and viewing animals in a sanctuary.
 *
 * Layout:
 *   NORTH:  Search field, type combo box, injured checkbox, search button
 *   CENTER: Scrollable text area showing results
 *   SOUTH:  Status label showing match count
 */
public class SanctuaryGUI extends JFrame {

    private Sanctuary sanctuary;


    private JTextField nameField;
    private JComboBox<String> typeCombo;
    private JCheckBox injuredCheck;
    private JButton searchButton;
    private JTextArea resultArea;
    private JLabel statusLabel;

    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);


        setLayout(new BorderLayout());


        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JLabel("Search:"));
        nameField = new JTextField(14);
        northPanel.add(new JLabel("Type:"));
        typeCombo = new JComboBox<String>(new String[]{"All", "Bird", "Reptile", "Marine"});
        northPanel.add(typeCombo);
        injuredCheck = new JCheckBox("Injured or Critical");
        northPanel.add(injuredCheck);
        searchButton = new JButton("Search");
        northPanel.add(searchButton);
        add(northPanel, BorderLayout.NORTH);


        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);


        statusLabel = new JLabel("Ready");
        add(statusLabel, BorderLayout.SOUTH);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSearch();
            }
        });


        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                runSearch();
            }
        });

        setLocationRelativeTo(null);
    }

    /**
     * Stores the Sanctuary to search over.
     */
    public void setModel(Sanctuary s) {
        this.sanctuary = s;
        setTitle("Caribbean Wildlife Conservation Tracker - " + s.getName());
    }

    /**
     * Filters the sanctuary's animals based on the GUI controls and
     * displays matching results.
     *
     *
     * Steps:
     * 1. Get text from nameField (trim, convert to lowercase)
     * 2. Get selected type from typeCombo
     * 3. Get checkbox state from injuredCheck
     * 4. Loop through sanctuary's animals:
     *    - If text is non-empty, keep only animals whose species or nickname
     *      contains the text (case-insensitive)
     *    - If type is not "All", keep only matching type
     *    - If checkbox is selected, keep only "Injured" or "Critical" animals
     * 5. Build result string and set in resultArea
     * 6. Set statusLabel: "No matches", "1 result", or "N results"
     */
    private void runSearch() {
        if(sanctuary==null) {
            return;
        }
        String text = nameField.getText().trim().toLowerCase();
        String selectedType= (String) typeCombo.getSelectedItem();
        boolean injured = injuredCheck.isSelected();

        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal a : sanctuary.getAnimals()) {
            if(!text.isEmpty()) {
                String species = a.getSpecies().toLowerCase();
                String nickname = a.getNickname().toLowerCase();
                if(!species.contains(text) && !nickname.contains(text)) {
                    continue;
                }
            }
            if(!selectedType.equals("All") && !a.getType().equals(selectedType)) {
                continue;
            }
            if(injured) {
                String health = a.getHealthStatus();
                if(!health.equals("Injured") && !health.equals("Critical")) {
                    continue;
                }
            }
            animals.add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (Animal a : animals) {
            sb.append(a.toString()).append("\n");
        }
        resultArea.setText(sb.toString());

        int count = animals.size();
        if (count == 0) {
            statusLabel.setText("No matches");
        } else if (count == 1) {
            statusLabel.setText("1 result");
        } else {
            statusLabel.setText(count + " results");
        }
    }

    /**
     * Creates a demo sanctuary, populates it, and launches the GUI.
     *
     */
    public static void main(String[] args) {
        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);

        caroni.addAnimal(new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true));
        caroni.addAnimal(new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true));
        caroni.addAnimal(new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true));
        caroni.addAnimal(new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0));
        caroni.addAnimal(new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0));
        caroni.addAnimal(new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000));

        SanctuaryGUI gui = new SanctuaryGUI();
        gui.setModel(caroni);
        gui.setVisible(true);
    }
}
