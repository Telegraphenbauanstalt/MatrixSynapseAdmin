package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import nl.donkeysbreakfast.matrixsynapseadmin.api.LoginUser;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class StartView extends ViewWithContext {

    private final LoginUser loginUser;

    public StartView(LoginUser loginUser) {
        super("start.ftl");
        this.loginUser = loginUser;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

}
