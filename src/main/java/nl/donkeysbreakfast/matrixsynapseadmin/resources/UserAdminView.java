package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.views.View;
import nl.donkeysbreakfast.matrixsynapseadmin.api.Users;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class UserAdminView extends View {

    private final Users users;

    public UserAdminView(Users users) {
        super("user_admin_userlist.ftl");
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

}
