package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 * 
 * siehe https://matrix.org/docs/spec/client_server/r0.6.0#identifier-types
 * 
 */
public class MatrixIdUserIdentifier {
    
    private final String type = "m.id.user";
    private String user;

    public MatrixIdUserIdentifier() {
    }

    public MatrixIdUserIdentifier(String user) {
        this.user = user;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public String getUser() {
        return user;
    }
    
    
    
}
