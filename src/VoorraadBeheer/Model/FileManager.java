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
            fileWriter.write("name,description,stock,timeToTake\n");

            for (Medication medication : data) {
                fileWriter.write(medication.getName() + "," + medication.getDescription() + "," + medication.getStock() + "," + medication.getTimeToTake() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public TableView<Medication> loadFromFile() {
        return null;
    }
}
