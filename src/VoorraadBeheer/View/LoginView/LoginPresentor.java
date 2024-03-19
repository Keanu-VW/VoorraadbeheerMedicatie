package VoorraadBeheer.View.LoginView;

import VoorraadBeheer.View.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.View.MedicationListView.MedicationListView;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class LoginPresentor {
    private MedicationListView view1;
    private final LoginView view;

    public LoginPresentor(LoginView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
                                           //lambda-uitdrukking
       view.getRegisterButton().setOnAction(e -> {
           // Toon de alert
           view.getAlert().showAndWait();
        });

       view.getLoginButton().setOnAction(e -> {
           if ("".equals(view.getUserNameField().getText()) || "Fadi".equals(view.getUserNameField().getText()) || "Keanu".equals(view.getUserNameField().getText())) {
               // Create a new MedicationListView and presenter
               MedicationListView medicationListView = new MedicationListView();


               // Create a new stage and scene for the medicationListView
               Stage medicationListStage = new Stage();
               Scene medicationListScene = new Scene(medicationListView, 1000, 600);
               medicationListStage.setScene(medicationListScene);

               new MedicationListPresentor(medicationListView, view.getUserNameField().getText());

               // show the new stage
                medicationListStage.show();

                // Close the login stage
                Stage loginStage = (Stage) view.getScene().getWindow();
                loginStage.close();

           }


           else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Fout");
           alert.setHeaderText(null);
           alert.setContentText("Ongeldige gebruikersnaam");
           alert.showAndWait();
       }
       });

    }

    private void updateView() {

    }
    public void addWindowEventHandlers(Stage eenStage) {
        eenStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
                if (alert.getResult() != ja ) {
                    event.consume();
                }
            }
        });
    }
}