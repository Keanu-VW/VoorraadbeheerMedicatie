package VoorraadBeheer.Model;

import java.time.LocalTime;

public class Medication {
    private String name;
    private String description;
    private int stock;
    private String timeToTake;
    private MedicationCat category;

    public Medication(String name, String description, int stock, String timeToTake, MedicationCat category) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.timeToTake = timeToTake;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public String getTimeToTake() {
        return timeToTake;
    }

    public MedicationCat getCategory() {
        return category;
    }
}