package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.AuthUser;
import javax.ws.rs.core.Response;

/**
 *
 * @author Telegraphenbauanstalt
 */
@Path("/logout")
public class LogoutResource {

    @POST
    @PermitAll
    @Timed
    public Response postLogout(@Auth AuthUser user) {

        Logger.getLogger(ServerVersionResource.class.getName()).info(String.format("%s", user));

        if (user != null) {
            // TODO log out auf Server
        }

        return Response
                .status(Response.Status.UNAUTHORIZED)
                .header("WWW-Authenticate", "Basic realm=\"MatrixSynapseAdmin Login\"")
                .entity("")
                .build();

    }

}
