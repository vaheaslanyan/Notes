package com.urartusoftware.reactor.daos;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    /* Constructors ------------------------------------------------------------*/

    public UserDAO() {
        super();
    }

    public UserDAO(String email, String password, String firstName, String lastName) {
        super();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* toString ----------------------------------------------------------------*/

    @Override
    public String toString() {
        return "User [userId=" + userId
                + ", email=" + email
                + ", password=" + password
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + "]";
    }

    /* Getters & Setters -------------------------------------------------------*/

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
