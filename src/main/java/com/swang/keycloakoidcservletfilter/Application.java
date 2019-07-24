package com.swang.keycloakoidcservletfilter;

import org.keycloak.adapters.servlet.KeycloakOIDCFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public FilterRegistrationBean oidcFilter(){
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new KeycloakOIDCFilter());
		registrationBean.setName("oidcFilter");
		registrationBean.addUrlPatterns("/keycloak/*","/protected/*");
		registrationBean.addInitParameter("keycloak.config.resolver","com.swang.keycloakoidcservletfilter.MyOidcConfigResolver");
		return registrationBean;
	}
}
