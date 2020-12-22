package com.webspoons.snippet_test.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "snippets")
public class SnippetEntity implements Serializable {
    private static final long serialVersionUID = 149141938220080258L;

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false, length = 50)
    private String snippet;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false)
    private Date expires_at;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer likes;

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(nullable = true)
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }
}
