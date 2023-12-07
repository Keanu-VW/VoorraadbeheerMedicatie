import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create a new MedicationInventory
        MedicationInventory inventory = new MedicationInventory("medications.csv");

        // Create some Medication objects
        Medication med1 = new Medication("Medicine1", Category.ALLERGIE, 10, LocalTime.of(12, 0));
        Medication med2 = new Medication("Medicine2", Category.BLOEDDRUK, 20, LocalTime.of(12, 0));
        Medication med3 = new Medication("Medicine3", Category.CHOLESTEROL, 30, LocalTime.of(12, 0));
        Medication med4 = new Medication("Medicine4", Category.ONTSTEKING, 40, LocalTime.of(12, 0));

        // Add the Medication objects to the inventory
        inventory.addMedication(med1);
        inventory.addMedication(med2);
        inventory.addMedication(med3);
        inventory.addMedication(med4);
    }
}