package com.apica.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("apica")
				.password(encoder.encode("apica"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("sonal")
				.password(encoder.encode("sonal"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests((authorizeHttpRequests) -> 
			authorizeHttpRequests
			.requestMatchers("/swagger**").hasAnyRole("ADMIN")
			.requestMatchers("/v1/journals/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
		)
		.httpBasic(Customizer.withDefaults())
		.formLogin(AbstractHttpConfigurer::disable)
		.build();
	}
	
}
