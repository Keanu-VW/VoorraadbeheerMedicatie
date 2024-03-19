package VoorraadBeheer.View.MedicationListView;


import VoorraadBeheer.Model.FileManager;
import VoorraadBeheer.View.NewMedicationView.NewMedicationPresentor;
import VoorraadBeheer.View.NewMedicationView.NewMedicationView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MedicationListPresentor {
    private MedicationListView medicationListView;
    private String userName;

    public MedicationListPresentor(MedicationListView medicationListView, String userName) {
        this.medicationListView = medicationListView;
        this.userName = userName;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Event handler for the new medication button
        this.medicationListView.getNewMedicationButton().setOnAction(e -> {
            // Create a new NewMedicationView and presenter
            NewMedicationView newMedicationView = new NewMedicationView();
            new NewMedicationPresentor(newMedicationView, medicationListView.getTableView());

            // Create a new stage and scene for the medicationListView
            Stage newMedicationStage = new Stage();
            Scene newMedicationScene = new Scene(newMedicationView, 400, 240);
            newMedicationStage.setScene(newMedicationScene);

            // show the new stage
            newMedicationStage.show();
        });

        // Event handler for closing the window (Saves to file with the file manager class)
        this.medicationListView.getScene().getWindow().setOnCloseRequest(e -> {
            FileManager fileManager = new FileManager(userName + ".csv");
            fileManager.saveToFile(medicationListView.getTableView());
        });

    }
    private void updateView() {
        medicationListView.getTitle().setText("Medication List for " + userName);

        // Filemanager > Get data from file > Get tableview > Send data to tableview (ToDo)
        FileManager fileManager = new FileManager(userName + ".csv");
        medicationListView.getTableView().setItems(fileManager.loadFromFile());


    }
}
