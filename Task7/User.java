package Task7;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private UserIdentifier identifier;
    private String password;

    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;

    private transient boolean loggedIn;

    public User(UserIdentifier identifier, String password) {
        this.identifier = identifier;
        this.password = password;

        registrationDate = LocalDateTime.now();
        loggedIn = false;
    }

    public UserIdentifier getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean value) {
        loggedIn = value;
    }

    public void setLastLoginDate(LocalDateTime date) {
        lastLoginDate = date;
    }

    @Override
    public String toString() {
        return identifier +
                ", logged=" + loggedIn +
                ", lastLogin=" + lastLoginDate;
    }
}