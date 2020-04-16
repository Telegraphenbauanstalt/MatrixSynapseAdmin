package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails extends User {

    private String consentVersion; // ? siehe https://github.com/matrix-org/synapse/blob/master/docs/consent_tracking.md
    private String consentServerNoticeSent;
    private String appserviceId;
    private Long creationTs;
    private String displayname;
    private String avatarUrl;
    //private List threepids; // []

    @JsonProperty("consent_version")
    public String getConsentVersion() {
        return consentVersion;
    }

    @JsonProperty("consent_server_notice_sent")
    public String getConsentServerNoticeSent() {
        return consentServerNoticeSent;
    }

    @JsonProperty("appservice_id")
    public String getAppserviceId() {
        return appserviceId;
    }

    @JsonProperty("creation_ts")
    public Long getCreationTs() {
        return creationTs;
    }

    @JsonProperty
    public String getDisplayname() {
        return displayname;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

}
