package Task7;

import java.util.Objects;

public class UserIdentifier {
    private int id;
    private String username;

    public UserIdentifier(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserIdentifier)) return false;

        UserIdentifier that = (UserIdentifier) o;

        return id == that.id &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}