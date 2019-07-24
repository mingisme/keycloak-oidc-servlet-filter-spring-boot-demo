package com.swang.keycloakoidcservletfilter;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.spi.HttpFacade;

import java.io.InputStream;


public class MyOidcConfigResolver implements KeycloakConfigResolver {
    @Override
    public KeycloakDeployment resolve(HttpFacade.Request request) {
        InputStream is = getClass().getResourceAsStream("/keycloak-oidc.json");
        if (is == null) {
            throw new IllegalStateException("Not able to find the file /keycloak-oidc.json");
        }

        return KeycloakDeploymentBuilder.build(is);
    }
}
