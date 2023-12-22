import java.util.ArrayList;
import java.util.List;

public class Login {
    private List<User> userList;
    private FileManager fileManager;

    public Login() {
        this.userList = new ArrayList<>();
        this.fileManager = new FileManager("UserList.csv");
        loadUserList();
    }

    public void loadUserList() {
        List<String[]> data = fileManager.loadFromFile();
        for (String[] row : data) {
            String name = row[0];
            String password = row[1];

            User user = new User(name, password);
            userList.add(user);
        }
    }

    public void saveUserList() {
        List<String[]> data = new ArrayList<>();
        for (User user : userList) {
            String[] row = new String[] {user.getName(), user.getPassword()};
            data.add(row);
        }
    }

    public User login(String name, String password) {
        for (User user : userList) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                System.out.println("Login successful");
                return user;
            }
        }
        System.out.println("Login error");
        return null;
    }

    public void createNewUser(String name, String password) {
        User user = new User(name, password);
        userList.add(user);
        saveUserList();
    }

}
