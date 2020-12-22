package com.webspoons.snippet_test.ui.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class AddSnippetResponseModel implements Serializable {
    private static final long serialVersionUID = 703808115434924345L;

    private String snippet;
    private String name;
    private Date expires_at;
    private String url;
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
