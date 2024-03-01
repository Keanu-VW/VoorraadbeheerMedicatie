package VoorraadbeheerMedicatie;

import java.time.LocalTime;
import java.util.*;

public class MedicationList {
    private List<Medication> medications;
    private String filePath;
    private FileManager fileManager;

    public MedicationList(String filePath) {
        this.medications = new ArrayList<>();
        this.filePath = filePath;
        this.fileManager = new FileManager(filePath);
        loadMedicationsFromFile();
    }

    private void loadMedicationsFromFile() {
        List<String[]> data = fileManager.loadFromFile();
        for (String[] row : data) {
            String name = row[0];
            Category category = Category.valueOf(row[1].toUpperCase());
            int quantity = Integer.parseInt(row[2]);
            LocalTime timeToTake = LocalTime.parse(row[3]);
            medications.add(new Medication(name, category, quantity, timeToTake));
        }
    }

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
        List<String[]> data = new ArrayList<>();
        for (Medication m : medications) {
            data.add(new String[] {m.getName(), m.getCategory().toString(), String.valueOf(m.getQuantity()), m.getTimeToTake().toString()});
        }
        fileManager.saveToFile(data);
    }
}