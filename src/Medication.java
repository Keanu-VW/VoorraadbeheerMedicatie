import java.time.LocalTime;

public class Medication {
    private String name;
    private Category category;
    private int quantity;
    private LocalTime timeToTake;



    public Medication(String name, Category category, int quantity, LocalTime timeToTake) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.timeToTake = timeToTake;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalTime getTimeToTake() {
        return timeToTake;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTimeToTake(LocalTime timeToTake) {
        this.timeToTake = timeToTake;
    }
}