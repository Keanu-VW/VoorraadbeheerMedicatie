import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class BestandsOpslag {
    private static final String BESTANDSNAAM = "medicatie_gegevens.txt";

    // Methode om medicatiegegevens op te slaan naar een bestand
    public static void opslaanNaarBestand(List<Medicijn> medicijnen) {
        Path filePath = Paths.get(BESTANDSNAAM);
        // De Path-klasse in Java wordt gebruikt om bestandssystemen-gerelateerde operaties uit te voeren.

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath))) {
          //Files.newBufferedWriter(filePath) gebruikt om een Path te verkrijgen naar het bestand "medicatie_gegevens.txt" en om een BufferedWriter te maken voor het schrijven naar dat bestand.
          //
           // PrintWriter in Java wordt vaak gebruikt voor het schrijven van tekst naar bestanden
            for (Medicijn medicijn : medicijnen) {
                writer.println(medicijn.getNaam() + ", " +
                        medicijn.getMedicijnCategorie() + ", " +
                        medicijn.getVoorraad() + ", " +
                        medicijn.getAanbevolenDosering() + ", " +
                        medicijn.getFrequentieInname());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode om medicatiegegevens te laden vanuit een bestand
    public static List<Medicijn> ladenVanBestand() {
        List<Medicijn> medicijnen = new ArrayList<>();
        Path filePath = Paths.get(BESTANDSNAAM);

        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String regel;
            while ((regel = bufferedReader.readLine()) != null) {
                String[] gegevens = regel.split(", ");
                if (gegevens.length == 5) {
                    String naam = gegevens[0];
                    String categorie = gegevens[1];
                    int voorraad = Integer.parseInt(gegevens[2]);
                    int aanbevolenDosering = Integer.parseInt(gegevens[3]);
                    int frequentieInname = Integer.parseInt(gegevens[4]);
                    Medicijn nieuwMedicijn = new Medicijn(naam, MedicijnCategorie.valueOf(categorie.toUpperCase()), voorraad, aanbevolenDosering, frequentieInname);
                    medicijnen.add(nieuwMedicijn);
                } else {
                    System.out.println("Ongeldige gegevens in de bestandsindeling: " +regel);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return medicijnen;
    }
}
