package nl.donkeysbreakfast.matrixsynapseadmin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.ext.Provider;
import nl.donkeysbreakfast.matrixsynapseadmin.resources.ViewWithContext;

/**
 * Setzt Kontext-Variablen in Views die ViewWithContext erweitern.
 * 
 * <!-- Idee:
 * https://stackoverflow.com/questions/45874611/jersey-filter-in-dropwizard-to-set-some-global-freemarker-variables
 * -->
 * 
 * @author Telegraphenbauanstalt
 */
//@Provider
@ContextForView
public class ContextFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(ContextFilter.class.getName());

    private String basePath;

    public ContextFilter(String basePath) {
        LOGGER.log(Level.INFO, "basePath: {0}", basePath);
        this.basePath = basePath;
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        if (responseContext.getEntity() != null
                && responseContext.getEntity() instanceof ViewWithContext) {

            LOGGER.log(Level.INFO, "basePath: {0}", basePath);
            ((ViewWithContext) responseContext.getEntity()).setBasePath(basePath);
        }

    }

}
