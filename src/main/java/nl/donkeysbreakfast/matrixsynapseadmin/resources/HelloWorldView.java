package nl.donkeysbreakfast.matrixsynapseadmin.resources;

import io.dropwizard.views.View;
import nl.donkeysbreakfast.matrixsynapseadmin.api.Saying;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class HelloWorldView extends View {

    private final Saying saying;

    public HelloWorldView(Saying saying) {
        super("hello-world.ftl");
        this.saying = saying;
    }

    public Saying getSaying() {
        return saying;
    }

}
