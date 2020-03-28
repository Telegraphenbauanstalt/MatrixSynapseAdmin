package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nl.donkeysbreakfast.matrixsynapseadmin.api.ServerVersion;

/**
 *
 * @author Telegraphenbauanstalt
 */
@Path("server_version")
//@Produces(MediaType.APPLICATION_JSON)
public class ServerVersionResource {

    private final Client client;
    private final String homeserver;

    public ServerVersionResource(Client client, String homeserver) {
        this.client = client;
        this.homeserver = homeserver;
    }

//    @GET
//    @RolesAllowed("admin")
//    public String getServerVersion() {
//        WebTarget webTarget = client.target(homeserver + "/_synapse/admin/v1/server_version");
//        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
//        Response response = builder.get();
//        String entityString = response.readEntity(String.class);
//        return entityString;
//        //return "{\"id\":\"test\"}";
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public ServerVersion getServerVersion() {
        WebTarget webTarget = client.target(homeserver + "/_synapse/admin/v1/server_version");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        ServerVersion entity = response.readEntity(ServerVersion.class);

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", entity));

        return entity;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("admin")
    public ServerVersionView getServerVersionHtml() {
        // TODO in Methode (Package Backend) auslagern
        WebTarget webTarget = client.target(homeserver + "/_synapse/admin/v1/server_version");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        ServerVersion entity = response.readEntity(ServerVersion.class);
        //
        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", entity));

        return new ServerVersionView(entity);
    }

}
