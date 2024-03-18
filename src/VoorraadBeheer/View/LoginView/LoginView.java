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
    private Button registerButton = new Button("Nieuwe gebruiker");
    private Image icon = new Image("th.jpg"); //om het te kunnen
    //gebruiken zonder OP

    // voor de achter grond foto en om daarboven te kunnen schrijven ...
    public static StackPane stackPaneRoot = new StackPane();

    private BorderPane borderPaneRoot = new BorderPane();

     private Scene LoginScene = new Scene(stackPaneRoot, 400, 500);

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
        borderPaneRoot.setTop(loginText);
        stackPaneRoot.getChildren().add(borderPaneRoot);
        stackPaneRoot.getChildren().add(backgroundImageView);
        //this, gidPane
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
        stackPaneRoot.getChildren().add(this);

        // Stel de titel en de inhoud van de alert in voor de knop niuewe gebruiker
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

    public Image getIcon() {
        return icon;
    }


    public Scene getLoginScene() {
        return LoginScene;
    }
}
