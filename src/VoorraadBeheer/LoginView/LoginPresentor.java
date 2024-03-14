package VoorraadBeheer.LoginView;

import VoorraadBeheer.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.MedicationListView.MedicationListView;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

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
                                           //lambda-uitdrukking
       view.getRegisterButton().setOnAction(e -> {
           // Toon de alert
           view.getAlert().showAndWait();
        });

       view.getLoginButton().setOnAction(e -> {
           if ("".equals(view.getUserNameField().getText()) || "Fadi".equals(view.getUserNameField().getText()) || "Keanu".equals(view.getUserNameField().getText())) {
               // Create a new MedicationListView and presenter
               MedicationListView medicationListView = new MedicationListView();
               new MedicationListPresentor(medicationListView);

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
}