package VoorraadBeheer.View.NewUserView;

import VoorraadBeheer.Model.MedicationCat;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NewUserView extends BorderPane {
    VBox root = new VBox();

    HBox nameBox = new HBox();
    Text nameText = new Text("Name: ");
    TextField nameField = new TextField();
    HBox passwordBox = new HBox();
    Text passwordText = new Text("Password: ");
    TextField passwordField = new TextField();


    public NewUserView(){
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
        passwordBox.setSpacing(10);

        // Add all the HBoxes to the root VBox
        root.getChildren().addAll(nameBox, passwordBox);

        // Add the respective Text and TextField nodes to each HBox
        nameBox.getChildren().addAll(nameText, nameField);
        passwordBox.getChildren().addAll(passwordText, passwordField);

        // Set the root VBox as the center of the BorderPane
        this.setCenter(root);
    }

    public TextField getNameField() {
        return nameField;
    }

       public TextField getPasswordField() {
            return passwordField;
        }
}
