package VoorraadBeheer.View.LoginView;

import VoorraadBeheer.View.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.View.MedicationListView.MedicationListView;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;


public class LoginPresentor {
    private MedicationListView view1;
    private final LoginView view;

    public LoginPresentor(LoginView view) {
        this.view = view;

    addEventHandlers();

        updateView();





}

    private void addEventHandlers() {
        //lambda-uitdrukking
        view.getRegisterButton().setOnAction(e -> {
            // Toon de alert
            view.getAlert().showAndWait();

        });
        //ga naar de andere pagine, verander de scene
        view.getLoginButton().setOnAction(e -> {
            if ("Fadi".equals(view.getUserNameField().getText()) || "Kenua".equals(view.getUserNameField().getText())) {
                // Ga naar de andere pagina
                // Wijzig de huidige scene naar de scene van de volgende pagina
                //onderstaande codes als we in dezelfde stage willen blijven
                MedicationListView medicationListView = new MedicationListView();
                MedicationListPresentor medicationListPresentor = new MedicationListPresentor(medicationListView);
                view.getScene().setRoot(medicationListView);
                medicationListView.getScene().getWindow().sizeToScene();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fout");
                alert.setHeaderText(null);
                alert.setContentText("Ongeldige gebruikersnaam");
                alert.showAndWait();
            }
        });
    }
 public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hieronder stopt het programma");
                alert.setContentText("ben je zeker ?");
                alert.setTitle("opgelet");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals("neen")) {
                    event.consume();
                }
            }
        });
    }




    private void updateView() {
        //date van de model
    }
}
