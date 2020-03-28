package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.auth.Auth;
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
import nl.donkeysbreakfast.matrixsynapseadmin.api.Users;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.AuthUser;

/**
 *
 * @author Telegraphenbauanstalt
 */
@Path("") // Every resource class must have a @Path annotation.
public class UserAdminResource {

    private final Client client;
    private final String homeserver;

    public UserAdminResource(Client client, String homeserver) {
        this.client = client;
        this.homeserver = homeserver;
    }

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Users getUsers(@Auth AuthUser user) {

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", user));

        WebTarget webTarget = client.target(homeserver)
                .path("/_synapse/admin/v2/users");

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
        Response response = builder.get();
        Users entity = response.readEntity(Users.class);

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", entity));

        return entity;
    }

    @GET
    @Path("users")
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("admin")
    public UserAdminView getUsersHtml(@Auth AuthUser user) {

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", user));

        WebTarget webTarget = client.target(homeserver)
                .path("/_synapse/admin/v2/users");

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
        Response response = builder.get();
        Users entity = response.readEntity(Users.class);

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", entity));

        return new UserAdminView(entity);
    }
}
