// Imports
import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class MedicationInventory {
    // List of medications (Look at class medication for more info)
    private List<Medication> medications;

    // File path for medications.csv
    private String filePath;

    // Constructor taking in the filePath. Creating a new file if it doesn't exist
    public MedicationInventory(String filePath) {
        this.medications = new ArrayList<>();
        this.filePath = filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadMedicationsFromFile();
    }

    // After creating a new MedicationInventory object, load the medications from the file and put it in the medications list
    private void loadMedicationsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                Category category = Category.valueOf(values[1].toUpperCase());
                int quantity = Integer.parseInt(values[2]);
                LocalTime timeToTake = LocalTime.parse(values[3]);
                medications.add(new Medication(name, category, quantity, timeToTake));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a medication to the list of medications if it does not exist there yet
    public void addMedication(Medication medication) {
        boolean found = false;
        for (Medication m : medications) {
            if (m.getName().equals(medication.getName())) {
                m.setQuantity(m.getQuantity() + medication.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            medications.add(medication);
        }
        saveMedicationsToFile();
    }

    // Remove a medication from the list of medications
    public void removeMedication(Medication medication) {
        this.medications.remove(medication);
        saveMedicationsToFile();
    }

    // Edit a medication from the list of medications
    public void editMedication(Medication oldMedication, Medication newMedication) {
        int index = this.medications.indexOf(oldMedication);
        if (index != -1) {
            this.medications.set(index, newMedication);
            saveMedicationsToFile();
        }
    }

    // Save the medications list to the file
    private void saveMedicationsToFile() {
        // Try to catch errors
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            // Create a Set from the medications list to remove duplicates
            Set<Medication> uniqueMedications = new HashSet<>(medications);
            // Iterate over the unique medications
            for (Medication medication : uniqueMedications) {
                // Write the medication to the file
                // %s for string, %d for integer, %n for new line
                writer.printf("%s,%s,%d,%s%n", medication.getName(), medication.getCategory(), medication.getQuantity(), medication.getTimeToTake());
            }
        } catch (FileNotFoundException e) {
            // Print the exception's message to the console
            System.out.println(e.getMessage());
        }
    }
}