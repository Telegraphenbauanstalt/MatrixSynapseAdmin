package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 *
 * siehe https://matrix.org/docs/spec/client_server/r0.6.0#password-based
 * https://matrix.org/docs/spec/client_server/r0.6.0#post-matrix-client-r0-login
 *
 */
public class AuthDict {

    private final String type = "m.login.password";
    private MatrixIdUserIdentifier identifier;

    private String password;
    //private String device_id;
    //private String initial_device_display_name;

    public AuthDict() {
    }

    public AuthDict(MatrixIdUserIdentifier identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public MatrixIdUserIdentifier getIdentifier() {
        return identifier;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

}
