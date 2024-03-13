package VoorraadBeheer.View.LoginView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginView extends GridPane {
   private Text loginText = new Text("  Login  ");
    private ImageView backgroundImageView = new ImageView("achtergrond foto.png");
    private TextField userNameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Inloggen");
    private static Button registerButton = new Button("Nieuwe gebruiker");
    public static Image icon = new Image("th.jpg"); //om het te kunnen
    //gebruiken zonder OP

    // voor de achter grond foto en om daarboven te kunnen schrijven ...
    public static StackPane root = new StackPane();

    private BorderPane root1 = new BorderPane();

     public static Scene scene = new Scene(root, 400, 500);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);





    public LoginView (){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes(){

    }
    private void layoutNodes(){
        loginText.setFont(Font.font("Verdana", 30));
        loginText.setFill(Color.LIGHTSALMON);
        root1.setTop(loginText);

        root1.setTop(loginText);
        root.getChildren().add(root1);
        root.getChildren().add(backgroundImageView);

        //this, root1 borderPane
        this.setAlignment(Pos.TOP_LEFT);
        //Gebruik Hgap en Vgap om de
        //ruimte tussen de cellen in te stellen
        this.setVgap(10);
        this.setPadding(new Insets(200, 25, 25, 25));
        userNameField.setPromptText("Gebruikersnaam");
        this.add(userNameField, 0, 0);


        passwordField.setPromptText("Wachtwoord");
        this.add(passwordField, 0, 1);
        this.add(loginButton, 0, 2);
        this.add(registerButton, 1, 2);

        // Voeg de GridPane toe aan de StackPane
        root.getChildren().add(this);

        // Stel de titel en de inhoud van de alert in
        alert.setTitle("Nieuwe gebruiker");
        //Door null in te stellen, verwijder je de standaard kopregel die bij bepaalde Alert-typen wordt weergegeven.
        alert.setHeaderText(null);
        //                                                                   die werkt momenteel niet.
        alert.setContentText("Je verzoek is ingediend voor gebruiker: " + getUserNameField().getText());

    }

    public Text getLoginText() {
        return loginText;
    }

    public TextField getUserNameField() {
        return userNameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public  Button getRegisterButton() {
        return registerButton;
    }

    public Alert getAlert() {
        return alert;
    }
}
