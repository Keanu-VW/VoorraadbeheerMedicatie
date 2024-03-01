package OldCode.VoorraadbeheerMedicatie;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToFile(List<String[]> newData) {
        List<String[]> existingData = loadFromFile();

        //Had to add to make sure data was unique, could probably use other data types but ran out of time (Edit: Broke it)
        for (String[] newRow : newData) {
            boolean exists = false;
            for (String[] existingRow : existingData) {
                if (Arrays.equals(newRow, existingRow)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                existingData.add(newRow);
            }
        }

        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            for (String[] row : existingData) {
                writer.println(String.join(",", row));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String[]> loadFromFile() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}