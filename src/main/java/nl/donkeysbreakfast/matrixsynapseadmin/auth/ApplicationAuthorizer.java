package nl.donkeysbreakfast.matrixsynapseadmin.auth;

import io.dropwizard.auth.Authorizer;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class ApplicationAuthorizer implements Authorizer<User> {

    @Override
    public boolean authorize(User principal, String role) {
        return principal.getRoles() != null
                && principal.getRoles().contains(role);
    }

//    @Override
//    public boolean authorize(User principal, String role, ContainerRequestContext requestContext) {
//
//    }

}
