package VoorraadBeheer.View.NewMedicationView;

import VoorraadBeheer.Model.Medication;
import javafx.scene.control.TableView;

public class NewMedicationPresentor {

    private NewMedicationView newMedicationView;
    private TableView tableview;

    public NewMedicationPresentor(NewMedicationView newMedicationView, TableView tableView) {
        this.tableview = tableView;
        this.newMedicationView = newMedicationView;
        this.addEventHandlers();
        this.updateView();

    }

    private void addEventHandlers(){
        newMedicationView.getSaveButton().setOnAction(e -> {
            // Create a new medication
            Medication newMedication = new Medication(
                    newMedicationView.getNameField().getText(),
                    newMedicationView.getDescriptionField().getText(),
                    Integer.parseInt(newMedicationView.getStockField().getText()),
                    newMedicationView.getTimeToTakeField().getText(), newMedicationView.getCategoryField().getValue());

            // Save the new medication to the tableview
            tableview.getItems().add(newMedication);
            newMedicationView.getScene().getWindow().hide();
        });
    }

    private void updateView() {

    }
}

