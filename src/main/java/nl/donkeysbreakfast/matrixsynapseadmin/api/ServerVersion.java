package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 *
 * siehe
 * https://github.com/matrix-org/synapse/blob/master/docs/admin_api/version_api.rst
 *
 */
public class ServerVersion {

    private String serverVersion;
    private String pythonVersion;

    public ServerVersion() {
    }

    public ServerVersion(String serverVersion, String pythonVersion) {
        this.serverVersion = serverVersion;
        this.pythonVersion = pythonVersion;
    }

    @JsonProperty("server_version")
    public String getServerVersion() {
        return serverVersion;
    }

    @JsonProperty("python_version")
    public String getPythonVersion() {
        return pythonVersion;
    }

    @Override
    public String toString() {
        return "ServerVersion{" + "serverVersion=" + serverVersion + ", pythonVersion=" + pythonVersion + '}';
    }

}
