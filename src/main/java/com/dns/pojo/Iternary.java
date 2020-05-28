/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dns.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author shahd
 */



@Entity
@Table(name="iternaryTable") 
@DynamicUpdate
public class Iternary {
    
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment
      @Column(name="iternaryID", unique = true, nullable = false)
     private long Id;
     
     @Column(name="DayNo")
     private int DayNo;
     
     @Column(name="Description")
     private String Description;
     
//     @ManyToOne
//    @JoinColumn(name="postID")
//    private Post post;
     
     @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postID", nullable = false)
    private Post post;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public int getDayNo() {
        return DayNo;
    }

    public void setDayNo(int DayNo) {
        this.DayNo = DayNo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
     
     
     
     
    
}
