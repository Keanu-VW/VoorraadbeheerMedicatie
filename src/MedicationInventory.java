import java.io.*;
import java.util.*;

public class MedicationInventory {
    private List<Medication> medications;
    private String filePath;

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

    private void loadMedicationsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                Category category = Category.valueOf(values[1].toUpperCase());
                int quantity = Integer.parseInt(values[2]);
                medications.add(new Medication(name, category, quantity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMedication(Medication medication) {
        this.medications.add(medication);
        saveMedicationsToFile();
    }

    public void removeMedication(Medication medication) {
        this.medications.remove(medication);
        saveMedicationsToFile();
    }

    public void editMedication(Medication oldMedication, Medication newMedication) {
        int index = this.medications.indexOf(oldMedication);
        if (index != -1) {
            this.medications.set(index, newMedication);
            saveMedicationsToFile();
        }
    }

    private void saveMedicationsToFile() {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            StringBuilder sb = new StringBuilder();
            for (Medication medication : medications) {
                sb.append(medication.getName());
                sb.append(",");
                sb.append(medication.getCategory());
                sb.append(",");
                sb.append(medication.getQuantity());
                sb.append("\n");
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}