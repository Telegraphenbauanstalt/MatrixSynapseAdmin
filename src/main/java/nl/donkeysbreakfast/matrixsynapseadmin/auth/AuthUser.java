package nl.donkeysbreakfast.matrixsynapseadmin.auth;

import java.security.Principal;
import java.util.Set;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class AuthUser implements Principal {

    private final String name;
    private final String accessToken;

    private final Set<String> roles;

    public AuthUser(String name, String accessToken, Set<String> roles) {
        this.name = name;
        this.accessToken = accessToken;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "AuthUser{" + "name=" + name + ", accessToken=" + (accessToken != null && !accessToken.isEmpty()) + ", roles=" + roles + '}';
    }

}
