package com.website.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User", schema = "clientDB")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    
    @Column(name = "user_first_name")
    private String firstName;
    
    @Column(name = "user_last_name")
    private String lastName;
    
    @Column(name = "user_email")
    private String email;
    
    @Column(name = "user_userName")
    private String userName;

    @Column(name = "user_password")
    private String password;

    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String userEmail) {this.email = userEmail;}
    public void setUserName(String userName) {this.userName = userName;}
    public void setPassword(String userPassword) {this.password = userPassword;}
    
    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public String getUserName() {return userName;}
    public String getPassword() {return password;}
}
