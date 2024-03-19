package VoorraadBeheer.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.List;

public class FileManager {
    // String to save the filepath
    private String filePath;

    // Constructor
    public FileManager(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);

        // If the file does not exist, create a new file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToFile(TableView<Medication> table) {

        /*
        From what I understand:
           - Turn tableview into observable list
           - Try and catch to write to file
           - Remove all the content from the file first (Otherwise it would double the content, do this by putting append to false)
           - First the header (name, description, stock, timeToTake)
           - Then the data
         */

        ObservableList<Medication> data = table.getItems();
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write("name,description,stock,timeToTake,category\n");

            for (Medication medication : data) {
                fileWriter.write(medication.getName() + "," + medication.getDescription() + "," + medication.getStock() + "," + medication.getTimeToTake() + "," + medication.getCategory() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Medication> loadFromFile() {
        ObservableList<Medication> data = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // skip header line
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String description = fields[1];
                int stock = Integer.parseInt(fields[2]);
                String timeToTake = fields[3];
                MedicationCat category = MedicationCat.valueOf(fields[4]);
                Medication medication = new Medication(name, description, stock, timeToTake, category);
                data.add(medication);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
