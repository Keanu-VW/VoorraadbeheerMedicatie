package VoorraadBeheer.NewMedicationView;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NewMedicationView extends BorderPane {
    VBox root = new VBox();

        HBox nameBox = new HBox();
            Text nameText = new Text("Name: ");
            TextField nameField = new TextField();
        HBox descriptionBox = new HBox();
            Text descriptionText = new Text("Description: ");
            TextField descriptionField = new TextField();
        HBox stockBox = new HBox();
            Text stockText = new Text("Stock: ");
            TextField stockField = new TextField();
        HBox timeToTakeBox = new HBox();
            Text timeToTakeText = new Text("Time to take: ");
            TextField timeToTakeField = new TextField();
        HBox buttonBox = new HBox();
            Button saveButton = new Button("Save");
            Button cancelButton = new Button("Cancel");
    public NewMedicationView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){

    }

    private void layoutNodes(){
        // Set padding for the root VBox
        root.setPadding(new Insets(10, 10, 10, 10));

        // Set spacing between the children of the root VBox
        root.setSpacing(10);

        // Set spacing between the children of the HBoxes
        nameBox.setSpacing(10);
        descriptionBox.setSpacing(10);
        stockBox.setSpacing(10);
        timeToTakeBox.setSpacing(10);
        buttonBox.setSpacing(10);

        // Add all the HBoxes to the root VBox
        root.getChildren().addAll(nameBox, descriptionBox, stockBox, timeToTakeBox, buttonBox);

        // Add the respective Text and TextField nodes to each HBox
        nameBox.getChildren().addAll(nameText, nameField);
        descriptionBox.getChildren().addAll(descriptionText, descriptionField);
        stockBox.getChildren().addAll(stockText, stockField);
        timeToTakeBox.getChildren().addAll(timeToTakeText, timeToTakeField);
        buttonBox.getChildren().addAll(saveButton, cancelButton);

        // Set the root VBox as the center of the BorderPane
        this.setCenter(root);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getDescriptionField() {
        return descriptionField;
    }

    public TextField getStockField() {
        return stockField;
    }

    public TextField getTimeToTakeField() {
        return timeToTakeField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
