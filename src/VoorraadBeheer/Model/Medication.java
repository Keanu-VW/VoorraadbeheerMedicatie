package VoorraadBeheer.Model;

import java.time.LocalTime;

public class Medication {
    private String name;
    private String description;
    private int stock;
    private LocalTime timeToTake;

    public Medication(String name, String description, int stock, LocalTime timeToTake) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.timeToTake = timeToTake;
    }


}
