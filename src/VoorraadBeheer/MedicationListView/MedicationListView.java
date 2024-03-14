package VoorraadBeheer.MedicationListView;

import VoorraadBeheer.Model.Medication;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TableView;

import java.time.LocalTime;

public class MedicationListView extends BorderPane{
    private TableView<Medication> tableView = new TableView<>();

    private TableColumn<Medication, String> nameColumn = new TableColumn<>("Name");
    private TableColumn<Medication, String> descriptionColumn = new TableColumn<>("Description");
    private TableColumn<Medication, Integer> stockColumn = new TableColumn<>("Stock");
    private TableColumn<Medication, LocalTime> timeToTakeColumn = new TableColumn<>("Time to take");


    public MedicationListView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){

    }

    private void layoutNodes(){
        this.getChildren().add(tableView);
        tableView.getColumns().addAll(nameColumn, descriptionColumn, stockColumn, timeToTakeColumn);
    }




}
