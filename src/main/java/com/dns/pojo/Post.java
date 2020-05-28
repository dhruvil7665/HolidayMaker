/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author shahd
 */
@Entity 
@Table(name="posts_table")
@DynamicUpdate
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment
    @Column(name="postID", unique = true, nullable = false)
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
    
    @Column(name="title")
    private String title;
    
//    @ManyToOne
//    @JoinColumn(name="userID")
//    private User user;

//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="iternaryTable",joinColumns=@JoinColumn(name="iternaryID"),inverseJoinColumns=@JoinColumn(name="postID"))
//    private Set<Iternary> iter=new HashSet<>(0);
    
     @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userID", nullable = false)
    private User user;
    
    
   
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Iternary> iterList = new HashSet<Iternary>(0);

    
    @Column(name="countryOfTravel")
    private String countryOfTravel;
    
    @Column(name="travelledFrom")
    private String travelledFrom;
    
    @Column(name="monthOfVisit")
    private String monthOfVisit;
    
    @Column(name="postDate")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
   
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Likes> likes = new HashSet<Likes>(0);
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comments> comments = new HashSet<Comments>(0);

    public Set<Likes> getLikes() {
        return likes;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

  
    @Column(name="images")
    private String imageList;
    
   
    @Column(name="travelCheckList")
    private String travelCheckList;
//    
//    
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
//    private Set<Images> imageList = new HashSet<Images>(0);
//    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

     @ModelAttribute("iterList")
    public Set<Iternary> getIterList() {
        return iterList;
    }

    public void setIterList(Set<Iternary> iterList) {
        this.iterList = iterList;
    }



    public String getCountryOfTravel() {
        return countryOfTravel;
    }

    public void setCountryOfTravel(String countryOfTravel) {
        this.countryOfTravel = countryOfTravel;
    }

    public String getTravelledFrom() {
        return travelledFrom;
    }

    public void setTravelledFrom(String travelledFrom) {
        this.travelledFrom = travelledFrom;
    }

    public String getMonthOfVisit() {
        return monthOfVisit;
    }

    public void setMonthOfVisit(String monthOfVisit) {
        this.monthOfVisit = monthOfVisit;
    }

  
     @ModelAttribute("user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTravelCheckList() {
        return travelCheckList;
    }

    public void setTravelCheckList(String travelCheckList) {
        this.travelCheckList = travelCheckList;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

  

   
    
    
    
    
    
}
