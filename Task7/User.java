package Task7;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    int id;
    String name;
    String password;
    LocalDateTime lastLoginDate;
    boolean isLoggedIn;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isLoggedIn = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Login: " + name +
                ", LoggedIn: " + isLoggedIn +
                ", LastLogin: " + lastLoginDate;
    }
}