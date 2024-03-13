package OldCode.VoorraadbeheerMedicatie;

// Klasse die een medicijn vertegenwoordigt
class Medicijn   {


    private String naam;
    private MedicijnCategorie medicijnCategorie;
    private int voorraad;
    private int aanbevolenDosering;
    private int frequentieInname;

    public Medicijn(String naam, MedicijnCategorie medicijnCategorie, int voorraad, int aanbevolenDosering, int frequentieInname) {
        this.naam = naam;
        this.medicijnCategorie = medicijnCategorie;
        this.voorraad = voorraad;
        this.aanbevolenDosering = aanbevolenDosering;
        this.frequentieInname = frequentieInname;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }



    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public int getAanbevolenDosering() {
        return aanbevolenDosering;
    }

    public void setAanbevolenDosering(int aanbevolenDosering) {
        this.aanbevolenDosering = aanbevolenDosering;
    }

    public int getFrequentieInname() {
        return frequentieInname;
    }

    public void setFrequentieInname(int frequentieInname) {
        this.frequentieInname = frequentieInname;
    }

    public String getNaam() {
        return naam;
    }

    public MedicijnCategorie getMedicijnCategorie() {
        return medicijnCategorie;
    }

    public void setMedicijnCategorie(MedicijnCategorie medicijnCategorie) {
        this.medicijnCategorie = medicijnCategorie;
    }

    public int getVoorraad() {
        return voorraad;
    }

    @Override
    public String toString() {
        return "Medicijn{" +
                "naam='" + naam + '\'' +
                ", medicijnCategorie=" + medicijnCategorie +
                ", voorraad=" + voorraad +
                ", aanbevolenDosering=" + aanbevolenDosering +
                ", frequentieInname=" + frequentieInname +
                '}';
    }

    // Methode om de voorraad van het medicijn bij te werken
    public void updateVoorraad(int hoeveelheid) {
        this.voorraad += hoeveelheid;
    }
}
