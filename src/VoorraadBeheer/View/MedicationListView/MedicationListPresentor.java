package VoorraadBeheer.View.MedicationListView;


import VoorraadBeheer.Model.FileManager;
import VoorraadBeheer.NewMedicationView.NewMedicationPresentor;
import VoorraadBeheer.NewMedicationView.NewMedicationView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

    public MedicationListPresentor(VoorraadBeheer.MedicationListView.MedicationListView medicationListView) {
    }

    private void addEventHandlers() {
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

    }
    private void updateView() {
        medicationListView.getTitle().setText("Medication List for " + userName);
        FileManager fileManager = new FileManager(userName + ".csv");
    }
}
