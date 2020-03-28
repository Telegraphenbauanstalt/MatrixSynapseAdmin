package nl.donkeysbreakfast.matrixsynapseadmin.auth;

import java.security.Principal;
import java.util.Set;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class User implements Principal {

    private final String name;
    private final int userId;

    private final Set<String> roles;

    public User(String name, int userId, Set<String> roles) {
        this.name = name;
        this.userId = userId;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public Set<String> getRoles() {
        return roles;
    }

}
