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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author shahd
 */
@Entity
@Table(name="commentDesc") 
@DynamicUpdate
public class Comments {
 
    
       @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment
      @Column(name="commentID", unique = true, nullable = false)
     private long Id;
   
     
     @Column(name="commentDesc")
     private String commentDesc;
     
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Post getPost() {
        return post;
    }

//     @ManyToOne
    public void setPost(Post post) {
        this.post = post;
    }
//    @JoinColumn(name="postID")
//    private Post post;
     
     @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postID", nullable = false)
    private Post post;
     
     
     
     @Column(name="userId")
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

     
    
    
}
