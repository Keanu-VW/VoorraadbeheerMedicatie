package VoorraadBeheer.Model;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    // String to save the filepath
    private String filePath;

    // Constructor
    public FileManager(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        System.out.println("File path: " + file.getAbsolutePath());

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
        ObservableList<Medication> data = table.getItems();
        for (Medication medication : data) {
            try {
                FileWriter writer = new FileWriter(filePath, true);
                writer.write(medication.getName() + "," + medication.getDescription() + "," + medication.getStock() + "," + medication.getTimeToTake() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TableView<Medication> loadFromFile() {
        return null;
    }
}
