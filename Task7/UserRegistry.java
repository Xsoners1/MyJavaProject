package Task7;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserRegistry {
    private Set<User> users = new HashSet<>();
    private int idCounter = 1;

    public void registerUser(String login, String password) {
        User newUser = new User(idCounter, login, password);

        if (users.contains(newUser)) {
            System.out.println("Користувач " + login + " вже є у списку");
            return;
        }

        users.add(newUser);
        idCounter++;
        System.out.println("Користувач зареєстрований");
    }

    public void loginUser(String login, String password) {
        for (User user : users) {
            if (user.name.equals(login) && user.password.equals(password)) {
                user.isLoggedIn = true;
                user.lastLoginDate = LocalDateTime.now();
                System.out.println("Успішний вхід");
                return;
            }
        }
        System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
    }

    public void logoutUser(int userId) {
        for (User user : users) {
            if (user.id == userId) {
                user.isLoggedIn = false;
                System.out.println("Користувач вийшов");
                return;
            }
        }
        System.out.println("Користувача не знайдено");
    }

    public boolean isUserRegistered(String login) {
        for (User user : users) {
            if (user.name.equals(login)) {
                return true;
            }
        }
        return false;
    }

    public void removeUser(int id) {
        User toRemove = null;

        for (User user : users) {
            if (user.id == id) {
                toRemove = user;
                break;
            }
        }

        if (toRemove != null) {
            users.remove(toRemove);
            System.out.println("Користувач видалений");
        } else {
            System.out.println("Користувача не знайдено");
        }
    }

    public void printTotalUniqueUsers() {
        System.out.println("Унікальних користувачів: " + users.size());
    }

    public void displayAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}