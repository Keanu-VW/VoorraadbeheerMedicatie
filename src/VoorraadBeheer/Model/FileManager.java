package VoorraadBeheer.Model;

import java.io.File;
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

    //public void saveToFile(tableView<> tableData) {}

    //public tableView<> loadFromFile() {return null;}
}
