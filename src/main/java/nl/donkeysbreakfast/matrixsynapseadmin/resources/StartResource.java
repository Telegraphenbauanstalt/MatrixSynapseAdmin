package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.donkeysbreakfast.matrixsynapseadmin.ContextForView;
import nl.donkeysbreakfast.matrixsynapseadmin.api.LoginUser;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.AuthUser;

/**
 *
 * @author Telegraphenbauanstalt
 */
@Path("/start")
public class StartResource {

    private final AtomicLong counter;

    public StartResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("admin")
    @ContextForView
    @Timed
    public StartView getStartHtml(@Auth AuthUser user) {
        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", user));
        return new StartView(new LoginUser(-1L, user.getName()));
    }

}
