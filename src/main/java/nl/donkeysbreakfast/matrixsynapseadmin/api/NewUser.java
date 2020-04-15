package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 */
@JsonInclude(Include.NON_NULL) // null-Werte nicht ausgeben (hier: avatar_url)
public class NewUser {

    private String displayname;
    private String password;
    //private List<ThreePids> threepids;
    private String avatarUrl;
    private boolean admin;
    private boolean deactivated;

    public NewUser() {
    }

    @JsonProperty
    public String getDisplayname() {
        return displayname;
    }

    @JsonProperty
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("admin")
    public boolean isAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("deactivated")
    public boolean isDeactivated() {
        return deactivated;
    }

    @JsonProperty("deactivated")
    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

}
