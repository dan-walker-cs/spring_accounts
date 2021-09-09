package com.dan_walker_cs.spring_accounts.accounts.model;



import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;
    private boolean active;
    private String username;
    private String password;
    private String roles;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) { this.roles = roles; }

    public String getRoles() { return roles; }
}
