package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.AuthUser;
import javax.ws.rs.core.Response;

/**
 *
 * @author Telegraphenbauanstalt
 */
@Path("/logout")
public class LogoutResource {

    private final Client client;
    private final String homeserver;

    public LogoutResource(Client client, String homeserver) {
        this.client = client;
        this.homeserver = homeserver;
    }

    @POST
    @PermitAll
    @Timed
    public Response postLogout(@Auth AuthUser user) {

        Logger.getLogger(LogoutResource.class.getName())
                .log(Level.INFO, String.format("user: %s", user));

        if (user != null) {
            // log out auf Server

            WebTarget webTarget = client.target(homeserver)
                    .path("/_matrix/client/r0/logout");

            Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
            builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
            Response response = builder.post(Entity.json("{}"));
            String entity = response.readEntity(String.class);

            Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", response));
            Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", entity));
        }

        return Response
                .status(Response.Status.UNAUTHORIZED)
                .header("WWW-Authenticate", "Basic realm=\"MatrixSynapseAdmin Login\"")
                .type(MediaType.TEXT_HTML_TYPE)
                .entity("<p>Credentials are required to access this resource.</p>"
                        + "<p><a href=\"/admin\">Index page</a></p>")
                .build();

    }

}
