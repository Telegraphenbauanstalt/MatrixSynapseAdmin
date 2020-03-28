package nl.donkeysbreakfast.matrixsynapseadmin;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.cache.CacheBuilderSpec;
import io.dropwizard.client.JerseyClientConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class MatrixSynapseAdminConfiguration extends Configuration {

    @Valid
    @NotNull
    private JerseyClientConfiguration jerseyClientConfiguration
            = new JerseyClientConfiguration();

    @NotEmpty
    private String homeserver;

    @NotNull
    private CacheBuilderSpec authenticationCachePolicy;

    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

    @JsonProperty("jerseyClient")
    public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClientConfiguration) {
        this.jerseyClientConfiguration = jerseyClientConfiguration;
    }

    @JsonProperty
    public String getHomeserver() {
        return homeserver;
    }

    @JsonProperty
    public void setHomeserver(String homeserver) {
        this.homeserver = homeserver;
    }

    @JsonProperty
    public CacheBuilderSpec getAuthenticationCachePolicy() {
        return authenticationCachePolicy;
    }

    @JsonProperty
    public void setAuthenticationCachePolicy(CacheBuilderSpec authenticationCachePolicy) {
        this.authenticationCachePolicy = authenticationCachePolicy;
    }

}
