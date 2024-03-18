package VoorraadBeheer.View.MedicationListView;


import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class MedicationListPresentor {
    private MedicationListView medicationListView;
    public MedicationListPresentor(MedicationListView medicationListView) {
        this.medicationListView = medicationListView;

        this.addEventHandlers();

        this.updateView();

    }
    private void addEventHandlers() {

    }
    private void updateView() {

    }

}
