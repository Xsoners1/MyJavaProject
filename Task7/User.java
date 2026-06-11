package Task7;

import java.time.LocalDateTime;

public class User {

    private UserIdentifier identifier;
    private String password;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
    private boolean loggedIn;

    public User(UserIdentifier identifier,
                String password) {

        this.identifier = identifier;
        this.password = password;
        this.registrationDate = LocalDateTime.now();
        this.loggedIn = false;
    }

    public UserIdentifier getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "ID=" + identifier.getId()
                + ", Login=" + identifier.getUsername()
                + ", LoggedIn=" + loggedIn;
    }
}