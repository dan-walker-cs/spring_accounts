package com.dan_walker_cs.spring_accounts.accounts.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


// Provides the entry point for user information necessary for authentication/authorization.
public class AppUserDetails implements UserDetails {

    private boolean active;
    private String username;
    private String password;

    private List<GrantedAuthority> authorities;

    // Collects data from a user object to provide an instance of UserDetails through AppUserDetails
    public AppUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();

        // takes the comma-separated list of roles, splits on the comma, and stores each role as a
        //      SimpleGrantedAuthority instance in the authorities class variable
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /*
     Accessor methods for UserDetails class variables
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    // Unimplemented functionality
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Unimplemented functionality
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Unimplemented functionality
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
