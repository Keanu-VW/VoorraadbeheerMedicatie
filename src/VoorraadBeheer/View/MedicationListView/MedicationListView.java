package VoorraadBeheer.View.MedicationListView;

import VoorraadBeheer.Model.Medication;
import VoorraadBeheer.Model.MedicationCat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalTime;

public class MedicationListView extends BorderPane{
    /*
    Root
        Hbox
            Text
            Text
        TableView
        Hbox
            Button
            Button
            Button

     */
    public VBox root = new VBox();
    private HBox buttonBox = new HBox();
    private HBox titleBox = new HBox();
    private Text title = new Text("Medication List");
    private Text nextMedTimer = new Text("Next Medication Timer: ");
    private TableView<Medication> tableView = new TableView<>();
    private Button newMedicationButton = new Button("New Medication");
    private Button editMedicationButton = new Button("Edit Medication");
    private Button deleteMedicationButton = new Button("Delete Medication");
    private TableColumn<Medication, String> nameColumn = new TableColumn<>("Name");
    private TableColumn<Medication, String> descriptionColumn = new TableColumn<>("Description");
    private TableColumn<Medication, Integer> stockColumn = new TableColumn<>("Stock");
    private TableColumn<Medication, LocalTime> timeToTakeColumn = new TableColumn<>("Time to take");
    private TableColumn<Medication, MedicationCat> categoryColumn = new TableColumn<>("Category");


    public MedicationListView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        //Door deze instellingen zal de TableView automatisch de juiste waarden weergeven in de cellen van elke kolom, gebaseerd op de attributen van het Medication-object dat wordt weergegeven.
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        timeToTakeColumn.setCellValueFactory(new PropertyValueFactory<>("timeToTake"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

    }

    private void layoutNodes(){
        // Set padding for the root VBox
        root.setPadding(new Insets(10, 10, 10, 10));

        // Set spacing between the children of the root VBox
        root.setSpacing(10);

        // Set spacing between the buttons in the buttonBox
        buttonBox.setSpacing(10);
         // Set the alignment of the buttonBox to center
        buttonBox.setAlignment(Pos.CENTER);

        // Set the minimum width for the TableView
        tableView.setMinWidth(600);

        // Set the minimum width for the columns in the TableView
        nameColumn.setMinWidth(150);
        descriptionColumn.setMinWidth(150);
        stockColumn.setMinWidth(150);
        timeToTakeColumn.setMinWidth(150);
        categoryColumn.setMinWidth(150);

        // Set the spacing for the titleBox
        titleBox.setSpacing(200);

        buttonBox.getChildren().addAll(newMedicationButton, editMedicationButton, deleteMedicationButton);
        titleBox.getChildren().addAll(title, nextMedTimer);
        tableView.getColumns().addAll(nameColumn, descriptionColumn, stockColumn, timeToTakeColumn, categoryColumn);
        root.getChildren().addAll(titleBox, tableView, buttonBox);

        // Add the root VBox to the MedicationListView
        this.setCenter(root);
    }

    public Button getNewMedicationButton() {
        return newMedicationButton;
    }

    public Text getTitle() {
        return title;
    }

    public TableView getTableView() {
        return tableView;
    }
}
