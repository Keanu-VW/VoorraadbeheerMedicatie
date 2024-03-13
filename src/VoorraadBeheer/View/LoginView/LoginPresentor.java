package VoorraadBeheer.View.LoginView;

import VoorraadBeheer.View.MedicationListView.MedicationListPresentor;
import VoorraadBeheer.View.MedicationListView.MedicationListView;

import javafx.scene.control.Alert;



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
       //ga naar de andere pagine, verander de scene
       view.getLoginButton().setOnAction(e -> {
           if ("Fadi".equals(view.getUserNameField().getText()) || "Kenua".equals(view.getUserNameField().getText())) {
               // Ga naar de andere pagina
               // Wijzig de huidige scene naar de scene van de volgende pagina

               MedicationListView medicationListView = new MedicationListView();
               MedicationListPresentor medicationListPresentor = new MedicationListPresentor( medicationListView);
               view.getScene().setRoot(medicationListView);
               medicationListView.getScene().getWindow().sizeToScene();

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
        //date van de model
    }
}