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
@Table(name="images_table") 
@DynamicUpdate
public class Images {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)//for auto increment
      @Column(name="imageID", unique = true, nullable = false)
     private long Id;
   
     
     @Column(name="Path")
     private String Path;
     
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public Post getPost() {
        return post;
    }

//     @ManyToOne
//    @JoinColumn(name="postID")
//    private Post post;
    public void setPost(Post post) {
        this.post = post;
    }
     
     @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postID", nullable = false)
    private Post post;
    
    
}
