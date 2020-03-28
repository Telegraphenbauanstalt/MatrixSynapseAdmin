package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import com.codahale.metrics.annotation.Timed;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nl.donkeysbreakfast.matrixsynapseadmin.api.Saying;

/**
 *
 * @author Telegraphenbauanstalt
 */
 @Path("/hello-world")
 //@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    //@RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Timed
    public HelloWorldView sayHelloHtml(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new HelloWorldView(new Saying(counter.incrementAndGet(), value));
    }

}
