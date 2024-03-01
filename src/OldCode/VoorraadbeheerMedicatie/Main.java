package OldCode.VoorraadbeheerMedicatie;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblHello = new Label("Hello World!");
        BorderPane root = new BorderPane(lblHello);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.createNewUser("admin", "admin");
        login.createNewUser("user1", "user1");
        login.createNewUser("user2", "user2");

        User user = login.login("admin", "admin");
        MedicationList userMedicationList = user.getMedicationList();

        Application.launch(args);
    }
}