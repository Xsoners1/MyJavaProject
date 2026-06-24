package Task7;

import java.io.Serializable;
import java.util.Objects;

public class UserIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof UserIdentifier))
            return false;

        UserIdentifier other = (UserIdentifier) obj;

        return id == other.id &&
                Objects.equals(username, other.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", login=" + username;
    }
}