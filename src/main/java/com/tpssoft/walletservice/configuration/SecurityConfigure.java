package com.tpssoft.walletservice.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(authz -> authz
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
				.build();
	}
	
}
