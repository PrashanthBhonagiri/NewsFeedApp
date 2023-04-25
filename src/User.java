import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String id;
    private String username;
    private String password;
    public User(String username, String password) throws NoSuchAlgorithmException {
        this.id = IdGenerator.generateId();
        this.username = username;
        this.password = PasswordUtils.hashPassword(password);
    }

    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        return PasswordUtils.hashPassword(password).equals(this.password);
    }

    public static boolean signUp(String username, String password) throws NoSuchAlgorithmException {
        ArrayList<User> users = Users.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        Users.addUser(new User(username, password));
        return true;
    }

    public static User signIn(String username, String password) throws NoSuchAlgorithmException {
        ArrayList<User> users = Users.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}
