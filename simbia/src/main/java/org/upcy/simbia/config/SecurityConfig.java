package org.upcy.simbia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDatailsService(){
        UserDetails user1 = User.withUsername("aaaa")
                .password("{noop}1234")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("bob")
                .password("{noop}1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, admin);
    }
}
