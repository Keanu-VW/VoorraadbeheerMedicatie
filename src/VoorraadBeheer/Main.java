package VoorraadBeheer;

import VoorraadBeheer.LoginView.LoginPresentor;
import VoorraadBeheer.LoginView.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

import static VoorraadBeheer.LoginView.LoginView.icon;
import static VoorraadBeheer.LoginView.LoginView.scene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        LoginView view = new LoginView();

        new LoginPresentor(view);
        // Stel de titel van het venster in en toon het
        primaryStage.setTitle("Medicatie beheer");

        // Icon toevoegen

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


