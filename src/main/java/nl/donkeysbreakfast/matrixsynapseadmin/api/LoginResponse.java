package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 *
 * siehe
 * https://matrix.org/docs/spec/client_server/r0.6.0#post-matrix-client-r0-login
 *
 */
public class LoginResponse {

    private String userId;
    private String accessToken;
    @Deprecated
    private String homeServer;
    private String deviceId;
    //private WellKnown well_known;

    public LoginResponse() {
    }

    public LoginResponse(String userId, String accessToken, String homeServer, String deviceId) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.homeServer = homeServer;
        this.deviceId = deviceId;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("home_server")
    public String getHomeServer() {
        return homeServer;
    }

    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public String toString() {
        return "LoginResponse{" + "userId=" + userId + ", accessToken=" + accessToken + ", homeServer=" + homeServer + ", deviceId=" + deviceId + '}';
    }

}
