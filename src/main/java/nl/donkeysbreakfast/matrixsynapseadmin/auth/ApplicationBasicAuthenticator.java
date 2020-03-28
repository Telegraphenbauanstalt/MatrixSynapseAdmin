package nl.donkeysbreakfast.matrixsynapseadmin.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import nl.donkeysbreakfast.matrixsynapseadmin.api.AuthDict;
import nl.donkeysbreakfast.matrixsynapseadmin.api.ErrorResponse;
import nl.donkeysbreakfast.matrixsynapseadmin.api.LoginResponse;
import nl.donkeysbreakfast.matrixsynapseadmin.api.MatrixIdUserIdentifier;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class ApplicationBasicAuthenticator implements Authenticator<BasicCredentials, User> {
    
    private final Client client;
    private final String homeserver;
    
    public ApplicationBasicAuthenticator(Client client, String homeserver) {
        this.client = client;
        this.homeserver = homeserver;
    }
    
    @Override
    public Optional<User> authenticate(BasicCredentials c) throws AuthenticationException {

        AuthDict authDict = new AuthDict(new MatrixIdUserIdentifier(c.getUsername()), c.getPassword());
        
        WebTarget webTarget = client.target(homeserver)
                .path("/_matrix/client/r0/login");
        //webTarget = webTarget.register(JacksonJsonProvider.class); // ???
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
//        Response response = builder.post(Entity.entity(authDict, MediaType.APPLICATION_JSON));
        Response response = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
////            Logger.getLogger(ApplicationBasicAuthenticator.class.getName())
////              .info(String.format("%s", mapper.writeValueAsString(authDict)));
//            response = builder.post(Entity.json(mapper.writeValueAsString(authDict)));
//            
//        } catch (JsonProcessingException e) {
//            Logger.getLogger(ApplicationBasicAuthenticator.class.getName())
//                    .log(Level.WARNING, "", e);
//        }
        response = builder.post(Entity.json("{\n"
                + "  \"type\": \"m.login.password\",\n"
                + "  \"username\": \"" + c.getUsername() + "\",\n"
                + "  \"password\": \"" + c.getPassword() + "\",\n"
                + "  \"initial_device_display_name\": \"Jungle Phone\"\n"
                + "}"));
        
        Logger.getLogger(ApplicationBasicAuthenticator.class.getName())
                .info(String.format("status %s", response.getStatus()));
        if (!response.getStatusInfo().getFamily().equals(Family.SUCCESSFUL)) {
            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            Logger.getLogger(ApplicationBasicAuthenticator.class.getName())
                    .info(String.format("%s %s", errorResponse.getErrcode(), errorResponse.getError()));
            return Optional.empty();
        }        
        LoginResponse entity = response.readEntity(LoginResponse.class);
        
        Logger.getLogger(ApplicationBasicAuthenticator.class.getName()).info(String.format("%s", response));
        Logger.getLogger(ApplicationBasicAuthenticator.class.getName()).info(String.format("%s", entity));

        // TODO auth mit Backend
//        if ("admin".equals(c.getUsername())
//                && "password2".equals(c.getPassword())) {
//
//            return Optional.of(new User(c.getUsername(), 1, Set.of(new String[]{"admin"})));
//        }
        if (response.getStatus() == 200) {
            return Optional.of(new User(entity.getUserId(), 1, new HashSet<>(Arrays.asList(new String[]{"admin"}))));
        }
        
        return Optional.empty();
    }
    
}
