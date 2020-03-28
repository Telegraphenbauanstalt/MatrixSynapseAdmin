package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.views.View;
import nl.donkeysbreakfast.matrixsynapseadmin.api.ServerVersion;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class ServerVersionView extends View {

    private final ServerVersion serverVersion;

    public ServerVersionView(ServerVersion serverversion) {
        super("server-version.ftl");
        this.serverVersion = serverversion;
    }

    public ServerVersion getServerVersion() {
        return serverVersion;
    }

}
