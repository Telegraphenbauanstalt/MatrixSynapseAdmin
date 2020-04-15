package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.auth.Auth;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nl.donkeysbreakfast.matrixsynapseadmin.api.NewUser;
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

        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", user));

        WebTarget webTarget = client.target(homeserver)
                .path("/_synapse/admin/v2/users");

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
        Response response = builder.get();
        Users entity = response.readEntity(Users.class);

        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", entity));

        return entity;
    }

    @GET
    @Path("users")
    @Produces(MediaType.TEXT_HTML)
    @RolesAllowed("admin")
    public UserAdminView getUsersHtml(@Auth AuthUser user) {

        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", user));

        WebTarget webTarget = client.target(homeserver)
                .path("/_synapse/admin/v2/users");

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
        Response response = builder.get();
        Users entity = response.readEntity(Users.class);

        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", response));
        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", entity));

        return new UserAdminView(entity);
    }

    @PUT
    @Path("users/{user_id}")
    @RolesAllowed("admin")
    public Response putUser(@PathParam("user_id") String userId, NewUser newUser, @Auth AuthUser user) {

        WebTarget webTarget = client.target(homeserver)
                .path("/_synapse/admin/v2/users/{user_id}")
                .resolveTemplate("user_id", userId);

        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        builder = builder.header("Authorization", "Bearer " + user.getAccessToken());
        Response response = builder.put(Entity.json(newUser));
        //Users entity = response.readEntity(Users.class);

        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("%s", response));
        return response;

    }

    @POST
    @Path("users")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postUserForm(@FormParam("user_id") String userId,
            @FormParam("display_name") String displayName,
            @FormParam("password") String password,
            @FormParam("admin") String admin,
            @Auth AuthUser user) {

        Logger.getLogger(UserAdminResource.class.getName())
                .info(String.format("user_id: %s, display_name: %s, password: %s, admin: %s ",
                        userId, displayName, password, admin));

        NewUser newUser = new NewUser();
        newUser.setDisplayname(displayName);
        newUser.setPassword(password);
        newUser.setAdmin((admin != null && admin.equals("true")));
        //newUser.setAvatarUrl(xxx);

        // TODO- nicht über path ?
//        try {
//            userId = URLEncoder.encode(userId, "US-ASCII");
//        } catch (UnsupportedEncodingException e) {
//            Logger.getLogger(UserAdminResource.class.getName())
//                    .severe(e.getMessage());
//        }
        Logger.getLogger(UserAdminResource.class.getName()).info(String.format("userId: %s", userId));
        return putUser(userId, newUser, user);
        
        // TODO kein return -> redirect GET !
    }
};
