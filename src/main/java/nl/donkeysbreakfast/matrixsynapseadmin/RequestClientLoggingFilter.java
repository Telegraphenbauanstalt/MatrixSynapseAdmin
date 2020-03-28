package nl.donkeysbreakfast.matrixsynapseadmin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

/**
 *
 * @author Telegraphenbauanstalt
 * 
 * siehe https://stackoverflow.com/questions/30187514/how-to-log-request-body-in-jax-rs-client
 * bzw. https://stackoverflow.com/questions/36676017/jax-rs-2-print-json-request
 * 
 */
//@Provider
public class RequestClientLoggingFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(RequestClientLoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        LOG.log(Level.INFO, clientRequestContext.getEntity().toString());
    }

}
