package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 */
@JsonIgnoreProperties(ignoreUnknown = true) 
public class User {

    private String name;
    private String passwordHash;
    private short guest;
    private short admin;
    //private ?? userType; - ignorieren
    private short deactivated;

    public User() {
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty("password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    @JsonProperty("is_guest")
    public short getGuest() {
        return guest;
    }

    @JsonProperty
    public short getAdmin() {
        return admin;
    }

    @JsonProperty
    public short getDeactivated() {
        return deactivated;
    }

}
