/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author shahd
 */
@Configuration
@ComponentScan(basePackages="com.dns")
@Entity
@Table(name="users_table")
@DynamicUpdate
public class User {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment
   @Column(name="userID", unique = true, nullable = false)
   private long Id;

   
    
    

  @Column(name="username")
  private String username;
    
  @Column(name="password")  
  private String password;
  
  @Column(name="firstname")
  private String firstname;
  
  @Column(name="lastname")
  private String lastname;
  
  @Column(name="role")
  private String role;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",cascade = {CascadeType.REMOVE,CascadeType.PERSIST },orphanRemoval = true)
  private Set<Post> postList = new HashSet<Post>(0);

 
  @Column(name="email" )  
  private String email;
  
  @Column(name="address")
  private String address;

  @Column(name="phone")
  private String phone;
  
  
  
     public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Set<Post> getPostList() {
        return postList;
    }

    public void setPostList(Set<Post> postList) {
        this.postList = postList;
    }
  
  
  
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
  public String getFirstname() {
  return firstname;
  }
  public void setFirstname(String firstname) {
  this.firstname = firstname;
  }
  public String getLastname() {
  return lastname;
  }
  public void setLastname(String lastname) {
  this.lastname = lastname;
  }
  public String getEmail() {
  return email;
  }
  public void setEmail(String email) {
  this.email = email;
  }
  public String getAddress() {
  return address;
  }
  public void setAddress(String address) {
  this.address = address;
  }
  public String getPhone() {
  return phone;
  }
  public void setPhone(String phone) {
  this.phone = phone;
  }
}
