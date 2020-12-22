package com.webspoons.snippet_test.shared;

import com.sun.istack.NotNull;

import java.io.Serializable;

public class SnippetDto implements Serializable {
    private static final long serialVersionUID = -1374529005796622088L;

    private String name;
    private String snippet;
    private int expires_in;
    private String password;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
