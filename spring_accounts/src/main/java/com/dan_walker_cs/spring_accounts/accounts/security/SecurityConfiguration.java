package com.dan_walker_cs.spring_accounts.accounts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Tells Spring that this is a web security configuration class.
@EnableWebSecurity
// This class extends Spring's default web security configuration class, allowing for custom
//      security configuration steps through instances provided by Spring.
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Service dependency to be injected
    @Autowired
    UserDetailsService userDetailsService;

    // AuthenticationManager handles authenticate, but is not directly affected.
    // We use the AuthenticationManagerBuilder class to configure a custom
    //      AuthenticationManager instance that Spring will provide.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Specifies the type of authentication desired, as well as
        //      the Service that provides the information to authenticate against.
        auth.userDetailsService(userDetailsService);
    }

    // HttpSecurity objects allows configuration of paths and their restrictions within the application's
    //      security context.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Specifies the mappings of paths to permissions and
        //      specifies form-based login, as well as logout functionality
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user/{username}").hasAnyRole("USER", "ADMIN")
                .antMatchers("/","/home","/register","/login").permitAll()
                .and().formLogin()
                .and().logout()
                .logoutSuccessUrl("/home");

        // Default successful login URL
        http.formLogin()
                .defaultSuccessUrl("/authsuccess", true);
    }

    // Exposes the PasswordEncoder Bean to Spring Security to assert encoding scheme.
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // Temporarily using cleartext
        return NoOpPasswordEncoder.getInstance();
    }
}
