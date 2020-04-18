package nl.donkeysbreakfast.matrixsynapseadmin;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import javax.ws.rs.client.Client;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.ApplicationAuthorizer;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.ApplicationBasicAuthenticator;
import nl.donkeysbreakfast.matrixsynapseadmin.auth.AuthUser;
import nl.donkeysbreakfast.matrixsynapseadmin.health.TemplateHealthCheck;
import nl.donkeysbreakfast.matrixsynapseadmin.resources.HelloWorldResource;
import nl.donkeysbreakfast.matrixsynapseadmin.resources.LogoutResource;
import nl.donkeysbreakfast.matrixsynapseadmin.resources.ServerVersionResource;
import nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminResource;

public class MatrixSynapseAdminApplication extends Application<MatrixSynapseAdminConfiguration> {
    
    public static void main(final String[] args) throws Exception {
        new MatrixSynapseAdminApplication().run(args);
    }
    
    @Override
    public String getName() {
        return "MatrixSynapseAdmin";
    }
    
    @Override
    public void initialize(final Bootstrap<MatrixSynapseAdminConfiguration> bootstrap) {
        bootstrap.addBundle(
                new AssetsBundle("/assets/", "/", "index.html", "root")
        );
        bootstrap.addBundle(
                new ViewBundle<MatrixSynapseAdminConfiguration>()
        );
    }
    
    @Override
    public void run(final MatrixSynapseAdminConfiguration configuration,
            final Environment environment) {
        
        JerseyClientConfiguration jerseyClientConfiguration
                = configuration.getJerseyClientConfiguration();
        //jerseyClientConfiguration.setChunkedEncodingEnabled(true); 
        // Matrix-Synapse-Server kann scheinbar nicht mit GZIPter Anfrage umgehen!
        jerseyClientConfiguration.setGzipEnabledForRequests(false);
        jerseyClientConfiguration.setGzipEnabled(false);
        final Client client = new JerseyClientBuilder(environment)
                .using(jerseyClientConfiguration)
                .build(getName());
        client.register(new EntityLoggingFilter());
        client.register(JacksonJsonProvider.class);
        
        final Authenticator basicAuthenticator = new ApplicationBasicAuthenticator(
                client, configuration.getHomeserver()
        );
        final CachingAuthenticator<BasicCredentials, AuthUser> cachingAuthenticator
                = new CachingAuthenticator<>(
                        environment.metrics(), basicAuthenticator,
                        configuration.getAuthenticationCachePolicy());
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<AuthUser>()
                        //.setAuthenticator(basicAuthenticator)
                        .setAuthenticator(cachingAuthenticator)
                        .setAuthorizer(new ApplicationAuthorizer())
                        .setRealm("MatrixSynapseAdmin Login")
                        .buildAuthFilter()
        ));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class)
        ); // damit @Auth-Annotation benutzt werden kann
        
        environment.jersey().register(
                new ContextFilter(environment.getApplicationContext().getContextPath()));
        
        final HelloWorldResource helloWorldResource
                = new HelloWorldResource("Hello %s", "world");
        environment.jersey().register(helloWorldResource);
        
        final TemplateHealthCheck templateHealthCheck
                = new TemplateHealthCheck("Hello %s");
        environment.healthChecks().register("template", templateHealthCheck);
        
        final LogoutResource logoutResource
                = new LogoutResource();
        environment.jersey().register(logoutResource);
        
        final ServerVersionResource serverVersionResource
                = new ServerVersionResource(client, configuration.getHomeserver());
        environment.jersey().register(serverVersionResource);
        
        final UserAdminResource userAdminResource
                = new UserAdminResource(client, configuration.getHomeserver());
        environment.jersey().register(userAdminResource);
        
    }
    
}
