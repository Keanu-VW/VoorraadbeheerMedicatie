package VoorraadBeheer.LoginView;

import VoorraadBeheer.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.MedicationListView.MedicationListView;

import javafx.scene.control.Alert;

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
           if ("Fadi".equals(view.getUserNameField().getText()) || "Kenua".equals(view.getUserNameField().getText())) {
               // Ga naar de andere pagina


               MedicationListView medicationListView = new MedicationListView();
               // Wijzig de huidige scene naar de scene van de volgende pagina
               root.getScene().setRoot(medicationListView.getMedicationListViewRoot());
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