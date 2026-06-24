package Task7;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserRegistry {

    private Map<UserIdentifier, User> users =
            new HashMap<>();

    private int nextId = 1;

    public void registerUser(String login,
                             String password) {

        for (User user : users.values()) {

            if (user.getIdentifier()
                    .getUsername()
                    .equals(login)) {

                System.out.println(
                        "Користувач вже існує"
                );

                return;
            }
        }

        UserIdentifier id =
                new UserIdentifier(
                        nextId,
                        login
                );

        users.put(
                id,
                new User(id, password)
        );

        nextId++;

        System.out.println(
                "Користувач доданий"
        );
    }

    public void loginUser(String login,
                          String password) {

        for (User user : users.values()) {

            if (
                    user.getIdentifier()
                            .getUsername()
                            .equals(login)
                            &&
                            user.getPassword()
                                    .equals(password)
            ) {

                user.setLoggedIn(true);

                user.setLastLoginDate(
                        LocalDateTime.now()
                );

                System.out.println(
                        "Вхід успішний"
                );

                return;
            }
        }

        System.out.println(
                "Невірний логін або пароль"
        );
    }

    public void displayUsers() {

        if (users.isEmpty()) {

            System.out.println(
                    "Список порожній"
            );

            return;
        }

        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void saveToFile(String file) {

        try (
                ObjectOutputStream out =
                        new ObjectOutputStream(
                                new FileOutputStream(file)
                        )
        ) {

            out.writeObject(users);

            System.out.println(
                    "Дані збережені"
            );

        } catch (IOException e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void loadFromFile(String file) {

        try (
                ObjectInputStream in =
                        new ObjectInputStream(
                                new FileInputStream(file)
                        )
        ) {

            users =
                    (HashMap<UserIdentifier, User>)
                            in.readObject();

            for (User user : users.values()) {
                user.setLoggedIn(false);
            }

            nextId =
                    users.size() + 1;

            System.out.println(
                    "База відновлена"
            );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
}