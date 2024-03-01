package OldCode.VoorraadbeheerMedicatie;

public class User {
    private String name;
    private String password;
    private MedicationList medicationList;
    private boolean IsAdmin = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.medicationList = new MedicationList(name + "_Meds.csv");
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public MedicationList getMedicationList() {
        return medicationList;
    }
}
