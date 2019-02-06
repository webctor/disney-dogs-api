package com.disney.studios.security;

/**
 * Created by Hector R Acosta on 2/5/19.
 */
/*
THIS IS A USER BEAN, IT HOLDS INFORMATION ABOUT A REAL USER.
IN A REAL WORLD WE WILL BE USING SOMETHING LIKE LDAP OR A MORE
SOPHISTICATED OBJECT TO HOLD THE INFORMATION OF A USER.
THIS IS ALSO FOR DEMO PURPOSES. YOU DON'T STORE DATA LIKE THIS
WITHOUT IT BEING ENCRYPTED.
 */
public class User {

    private String username;
    private String password;
    private String role;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
