import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.createNewUser("admin", "admin");
        login.createNewUser("user1", "user1");
        login.createNewUser("user2", "user2");

        User user = login.login("admin", "admin");
        MedicationList userMedicationList = user.getMedicationList();
    }
}