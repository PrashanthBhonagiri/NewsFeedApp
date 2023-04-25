import java.util.ArrayList;

public class Users {
    private static ArrayList<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        System.out.println("Creating new user : ");
        System.out.println("username : " + user.getUsername());
        System.out.println("userId : " + user.getId());
        userList.add(user);
    }

    public static void removeUser(User user) {
        userList.remove(user);
    }

    public static ArrayList<User> getAllUsers() {
        return userList;
    }
    public static void printUsers() {
        for (User user : userList) {
            System.out.println(user.toString());
            // System.out.println("User ID: " + user.getId());
            // System.out.println("Username: " + user.getUsername());
            System.out.println(); // adding an empty line between users for readability
        }
    }

}