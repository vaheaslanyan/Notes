package com.urartusoftware.reactor.models;

import com.urartusoftware.reactor.daos.UserDAO;

public class User {
    private int userId;
    private String email;
    private String firstName;
    private String lastName;

    public User(UserDAO userDAO) {
        this.userId = userDAO.getUserId();
        this.email = userDAO.getEmail();
        this.firstName = userDAO.getFirstName();
        this.lastName = userDAO.getLastName();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
