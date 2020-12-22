package com.webspoons.snippet_test.ui.model;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AddSnippetRequestModel implements Serializable {
    private static final long serialVersionUID = 1678707746150446542L;

    @Size(min = 2, max = 15, message = "Invalid input(Snippet Name)")
    private String name;

    @Size(min = 2, max = 15, message = "Invalid input(Snippet)")
    private String snippet;

    @NotNull(message = "Expiry time is empty.")
    private int expires_in;

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
