package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.jersey.errors.ErrorMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class ErrorView extends ViewWithContext {

    private final ErrorMessage errorMessage;

    public ErrorView(ErrorMessage errorMessage) {
        super("error.ftl");
        Logger.getLogger(ErrorView.class.getName())
                .log(Level.INFO, "{0}", errorMessage.toString());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

}
