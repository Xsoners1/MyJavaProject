package Task7;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class UserRegistry {

    private Map<UserIdentifier, User> users = new HashMap<>();
    private int idCounter = 1;

    public void registerUser(String login, String password) {

        for (UserIdentifier id : users.keySet()) {
            if (id.getUsername().equals(login)) {
                System.out.println("Користувач вже є у списку");
                return;
            }
        }

        UserIdentifier id = new UserIdentifier(idCounter++, login);
        users.put(id, new User(id, password));

        System.out.println("Користувач створений");
    }

    public void loginUser(String login, String password) {

        for (User u : users.values()) {
            if (u.getIdentifier().getUsername().equals(login)
                    && u.getPassword().equals(password)) {

                u.setLoggedIn(true);
                u.setLastLoginDate(LocalDateTime.now());
                System.out.println("Вхід успішний");
                return;
            }
        }

        System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
    }

    public void logoutUser(int id) {
        for (User u : users.values()) {
            if (u.getIdentifier().getId() == id) {
                u.setLoggedIn(false);
                return;
            }
        }
    }

    public void removeUser(int id) {
        UserIdentifier target = null;

        for (UserIdentifier key : users.keySet()) {
            if (key.getId() == id) {
                target = key;
                break;
            }
        }

        if (target != null) {
            users.remove(target);
        }
    }

    public LinkedList<User> getUserList() {
        return new LinkedList<>(users.values());
    }

    public LinkedList<User> getInOrder(Comparator<User> comparator) {
        LinkedList<User> list = new LinkedList<>(users.values());
        list.sort(comparator);
        return list;
    }

    public LinkedList<User> getFiltered(Predicate<User> predicate) {
        LinkedList<User> result = new LinkedList<>();

        for (User u : users.values()) {
            if (predicate.test(u)) {
                result.add(u);
            }
        }

        return result;
    }

    public void displayAllUsers() {
        for (User u : users.values()) {
            System.out.println(u);
        }
    }
}