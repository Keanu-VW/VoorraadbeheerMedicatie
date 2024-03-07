package VoorraadBeheer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {



        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 500);

        BorderPane root1 = new BorderPane();
        Text loginText = new Text("Login");
        loginText.setFont(Font.font("Verdana", 30));
        loginText.setFill(Color.LIGHTSALMON);
        root1.setTop(loginText);

        Line line = new Line(150, 0, scene.getWidth(), 0);
        line.setStrokeWidth(2);
        root.getChildren().add(line);

        // Bind de eindpositie van de lijn aan de breedte van de scene
        line.endXProperty().bind(scene.widthProperty());
        HBox loginBox = new HBox(loginText, line);
        loginBox.setAlignment(Pos.CENTER_LEFT); // Om de inhoud in het midden links te plaatsen

        root1.setTop(loginBox);
        root.getChildren().add(root1); // Voeg root1 toe aan de StackPane


        // Voeg de achtergrondafbeelding toe aan de StackPane
        Image backgroundImage = new Image("achtergrond foto.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);

        // Creëer een GridPane voor het gebruikersnaam- en wachtwoordveld
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Voeg een tekstveld toe voor gebruikersnaam
        TextField userNameField = new TextField();
        userNameField.setPromptText("Gebruikersnaam");
        grid.add(userNameField, 0, 0);

        // Voeg een tekstveld toe voor wachtwoord
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Wachtwoord");
        grid.add(passwordField, 0, 1);

        // Maak knoppen voor inloggen en nieuwe gebruiker registreren
        Button loginButton = new Button("Inloggen");
        Button registerButton = new Button("Nieuwe gebruiker");

        // Voeg de knoppen toe aan de GridPane
        grid.add(loginButton, 0, 2);
        grid.add(registerButton, 1, 2);

        // Voeg de GridPane toe aan de StackPane
        root.getChildren().add(grid);

        // Stel de titel van het venster in en toon het
        primaryStage.setTitle("Medicatie beheer");

        // Icon toevoegen
        Image icon = new Image("th.jpg");
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


       /* Scanner scanner = new Scanner(System.in);
        System.out.print("Gebruikersnaam; ");
        String gebruikersnaam = scanner.nextLine();

        List<Medicijn> medicijnen = BestandsOpslag.ladenVanBestand();

        // Aanmaken van een MedicatieBeheer object en weergave van het hoofdmenu
        MedicatieBeheer medicatieBeheer = new MedicatieBeheer(medicijnen);
        medicatieBeheer.toonAlleMedicijnen();  // Eerste weergave van medicijnen


        boolean doorgaan = true;

        while (doorgaan) {
            System.out.println("\nHoofdmenu:");
            System.out.println("1. Voeg nieuw medicijn toe");
            System.out.println("2. Toon alle medicijnen");
            System.out.println("3. Toon medicijnen per categorie");
            System.out.println("4. Toon medicijnen die bijna op zijn");
            System.out.println("5. Toon innameherinneringen");
            System.out.println("6. Opslaan en afsluiten");
            System.out.print("Keuze: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();  // Consumeer de nieuwe regel

            switch (keuze) {
                case 1:
                    // Nieuw medicijn toevoegen
                    System.out.print("Naam: ");
                    String naam = scanner.nextLine();
                    System.out.print("Categorie: ");
                    String categorieStr = scanner.nextLine();

                    try {
                        MedicijnCategorie categorie = MedicijnCategorie.valueOf(categorieStr.toUpperCase());
                        System.out.print("Voorraad: ");
                        int voorraad = scanner.nextInt();
                        System.out.print("Aanbevolen Dosering: ");
                        int aanbevolenDosering = scanner.nextInt();
                        System.out.print("Frequentie Inname: ");
                        int frequentieInname = scanner.nextInt();

                        Medicijn nieuwMedicijn = new Medicijn(naam, categorie, voorraad, aanbevolenDosering, frequentieInname);
                        medicatieBeheer.voegMedicijnToe(nieuwMedicijn);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ongeldige categorie. Medicijn niet toegevoegd.");
                    }
                    BestandsOpslag.opslaanNaarBestand(medicatieBeheer.getMedicijnen());

                    break;

                case 2:
                    // Alle medicijnen tonen
                    medicatieBeheer.toonAlleMedicijnen();
                    break;

                case 3:
                    // Medicijnen filteren op categorie
                    System.out.println("Beschikbare categorieën: " + Arrays.toString(MedicijnCategorie.values()));
                    System.out.print("Voer categorie in: ");
                    String filterCategorieStr = scanner.nextLine();

                    try {
                        MedicijnCategorie filterCategorie = MedicijnCategorie.valueOf(filterCategorieStr.toUpperCase());
                        List<Medicijn> gefilterdeMedicijnen = medicatieBeheer.filterOpCategorie(filterCategorie);

                        if (gefilterdeMedicijnen.isEmpty()) {
                            System.out.println("Geen medicijnen gevonden in de opgegeven categorie.");
                        } else {
                            System.out.println("Medicijnen in de categorie " + filterCategorie + ":");
                            for (Medicijn medicijn : gefilterdeMedicijnen) {
                                System.out.println("Naam: " + medicijn.getNaam() + ", Voorraad: " + medicijn.getVoorraad());
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ongeldige categorie. Probeer opnieuw.");
                    }
                    break;

                case 4:
                    // Medicijnen weergeven die bijna op zijn
                    List<Medicijn> bijnaOpMedicijnen = medicatieBeheer.toonBijnaOpMedicijnen();
                    if (bijnaOpMedicijnen.isEmpty()) {
                        System.out.println("Alle medicijnen hebben voldoende voorraad.");
                    } else {
                        System.out.println("Medicijnen die bijna op zijn:");
                        for (Medicijn medicijn : bijnaOpMedicijnen) {
                            System.out.println("Naam: " + medicijn.getNaam() + ", Voorraad: " + medicijn.getVoorraad());
                        }
                    }
                    break;

                case 5:
                    // Innameherinneringen weergeven
                    List<Medicijn> innameHerinneringen = medicatieBeheer.toonInnameHerinneringen();
                    if (innameHerinneringen.isEmpty()) {
                        System.out.println("Geen innameherinneringen voor de komende 48 uur.");
                    } else {
                        System.out.println("Innameherinneringen voor de komende 48 uur:");
                        for (Medicijn medicijn : innameHerinneringen) {
                            System.out.println("Naam: " + medicijn.getNaam() + ", Frequentie Inname: " + medicijn.getFrequentieInname());
                        }
                    }
                    break;

                    case 6:
                        // Opslaan naar bestand en afsluiten

                        BestandsOpslag.opslaanNaarBestand(medicatieBeheer.getMedicijnen());
                        doorgaan = false;
                        break;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }
        BestandsOpslag.opslaanNaarBestand(medicatieBeheer.getMedicijnen());
        // Sluit de scanner
        scanner.close();


*/

