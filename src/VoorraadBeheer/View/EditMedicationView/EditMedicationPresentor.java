package VoorraadBeheer.View.EditMedicationView;

import VoorraadBeheer.Model.Medication;
import javafx.scene.control.TableView;

public class EditMedicationPresentor {
    private EditMedicationView editMedicationView;
    private TableView tableview;

    public EditMedicationPresentor(EditMedicationView editMedicationView, TableView tableView) {
        this.tableview = tableView;
        this.editMedicationView = editMedicationView;
        this.addEventHandlers();
        this.updateView();

    }

    private void addEventHandlers(){
        editMedicationView.getSaveButton().setOnAction(e -> {
            // Create a new medication
            Medication newMedication = new Medication(
                    editMedicationView.getNameField().getText(),
                    editMedicationView.getDescriptionField().getText(),
                    Integer.parseInt(editMedicationView.getStockField().getText()),
                    editMedicationView.getTimeToTakeField().getText(), editMedicationView.getCategoryField().getValue());

            // Save the new medication to the tableview
            tableview.getItems().remove(tableview.getSelectionModel().getSelectedItem());
            tableview.getItems().add(newMedication);
            editMedicationView.getScene().getWindow().hide();
        });
    }

    private void updateView() {
        // Get selected medication from tableView
        Medication selectedMedication = (Medication) tableview.getSelectionModel().getSelectedItem();

        editMedicationView.nameField.setText(selectedMedication.getName());
        editMedicationView.descriptionField.setText(selectedMedication.getDescription());
        editMedicationView.stockField.setText(String.valueOf(selectedMedication.getStock()));
        editMedicationView.timeToTakeField.setText(selectedMedication.getTimeToTake());
        editMedicationView.catagoryField.setValue(selectedMedication.getCategory());
    }
}