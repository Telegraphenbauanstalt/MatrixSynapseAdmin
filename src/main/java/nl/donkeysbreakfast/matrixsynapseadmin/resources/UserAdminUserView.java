package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import nl.donkeysbreakfast.matrixsynapseadmin.api.UserDetails;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class UserAdminUserView extends ViewWithContext {

    private final UserDetails userDetails;

    public UserAdminUserView(UserDetails userDetails) {
        super("user_admin_user.ftl");
        this.userDetails = userDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

}
