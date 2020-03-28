package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class Users {

    private List<User> users;
    private String nextToken;

    public Users() {
        this.users = new ArrayList<>();
    }

    @JsonProperty
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("next_token")
    public String getNextToken() {
        return nextToken;
    }

}
