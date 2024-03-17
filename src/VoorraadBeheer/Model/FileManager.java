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

        // If the file does not xist, create a new file
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

    }

    public TableView<Medication> loadFromFile() {
        return null;
    }
}
