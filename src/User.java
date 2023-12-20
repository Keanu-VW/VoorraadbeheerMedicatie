public class User {
    private String name;
    private MedicationList medicationList;
    private boolean IsAdmin = false;

    private User(String name, MedicationList medicationList, boolean IsAdmin) {
        this.name = name;
        this.medicationList = medicationList;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }
}
