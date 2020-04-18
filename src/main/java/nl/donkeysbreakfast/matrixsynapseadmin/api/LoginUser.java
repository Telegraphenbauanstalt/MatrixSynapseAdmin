package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class LoginUser {

    private long id;

    private String name;

    public LoginUser() {
    }

    public LoginUser(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

}
