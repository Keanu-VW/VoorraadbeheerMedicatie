package VoorraadBeheer.LoginView;

import VoorraadBeheer.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.MedicationListView.MedicationListView;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static VoorraadBeheer.LoginView.LoginView.root;


public class LoginPresentor {
    private MedicationListView view1;
    private final LoginView view;

    public LoginPresentor(LoginView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        if (view.getScene().getWindow() != null){
            view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() { //anonieme innerklasse
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
                                           //lambda-uitdrukking
       view.getRegisterButton().setOnAction(e -> {
           // Toon de alert
           view.getAlert().showAndWait();
        });

       view.getLoginButton().setOnAction(e -> {
           String username = view.getUserNameField().getText();
           if ("".equals(username) || "Fadi".equals(username) || "Keanu".equals(username)) {
           // Create a new MedicationListView and presenter
           MedicationListView medicationListView = new MedicationListView();
           new MedicationListPresentor(medicationListView, username);

           // Create a new stage and scene for the medicationListView
           Stage medicationListStage = new Stage();
           Scene medicationListScene = new Scene(medicationListView, 1000, 600);
           medicationListStage.setScene(medicationListScene);

           // show the new stage
            medicationListStage.show();

            // Close the login stage
            Stage loginStage = (Stage) view.getScene().getWindow();
            loginStage.close();

       }
       else{
           Alert alert2 = new Alert(Alert.AlertType.ERROR);
           alert2.setTitle("Fout");
           alert2.setHeaderText(null);
           alert2.setContentText("Ongeldige gebruikersnaam");
           alert2.showAndWait();
       }
       });

    }

    private void updateView() {

    }
}