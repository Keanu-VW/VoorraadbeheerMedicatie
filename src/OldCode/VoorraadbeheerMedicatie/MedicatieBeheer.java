package OldCode.VoorraadbeheerMedicatie;

import java.util.List;
import java.util.stream.Collectors;

class MedicatieBeheer {
    private List<Medicijn> medicijnen;


    public MedicatieBeheer(List<Medicijn> medicijnen) {
        this.medicijnen = medicijnen;
    }

    public List<Medicijn> getMedicijnen() {
        return medicijnen;
    }

    public void setMedicijnen(List<Medicijn> medicijnen) {
        this.medicijnen = medicijnen;
    }

    // Methode om een nieuw medicijn toe te voegen
    public void voegMedicijnToe(Medicijn medicijn) {
        medicijnen.add(medicijn);
    }

    // Methode om alle medicijnen weer te geven
    public void toonAlleMedicijnen() {
        if (medicijnen.isEmpty()) {
            System.out.println("Geen medicijnen beschikbaar.");
        } else {
            System.out.println("Alle medicijnen:");
            for (Medicijn medicijn : medicijnen) {
                System.out.println(medicijn);
            }
        }
    }
    public void toonAlleMedicijnen(List<Medicijn> medicijnenLijst) {
        for (Medicijn medicijn : medicijnenLijst) {
            System.out.println("Naam: " + medicijn.getNaam() +
                    ", Categorie: " + medicijn.getMedicijnCategorie() +
                    ", Voorraad: " + medicijn.getVoorraad() +
                    ", Aanbevolen Dosering: " + medicijn.getAanbevolenDosering() +
                    ", Frequentie Inname: " + medicijn.getFrequentieInname());
        }
    }

    // Methode om medicijnen te filteren op categorie
    public List<Medicijn> filterOpCategorie(MedicijnCategorie categorie) {
        return medicijnen.stream()
                .filter(medicijn -> medicijn.getMedicijnCategorie() == categorie)
                .collect(Collectors.toList());
    }

    // Methode om medicijnen weer te geven die bijna op zijn
    public List<Medicijn> toonBijnaOpMedicijnen() {
        return medicijnen.stream()
                .filter(medicijn -> medicijn.getVoorraad() < 5)
                .collect(Collectors.toList());
    }

    // Methode om innameherinneringen weer te geven voor de komende 48 uur
    public List<Medicijn> toonInnameHerinneringen() {
        // Voor het eenvoudige voorbeeld nemen we aan dat de frequentie de uren tussen doses is
        int herinneringsTijdInUren = 48;

        return medicijnen.stream()
                .filter(medicijn -> medicijn.getFrequentieInname() <= herinneringsTijdInUren)
                .collect(Collectors.toList());
    }
}