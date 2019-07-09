package com.learn.springmongo.response;

import com.learn.springmongo.model.AuthorModel;

import java.io.Serializable;

public class AuthorResponse extends Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private AuthorModel authorModel;

    public AuthorResponse(AuthorModel authorModel) {
        this.authorModel = authorModel;
    }

    public AuthorResponse() { }

    public AuthorModel getAuthorModel() {
        return authorModel;
    }

    public AuthorResponse setAuthorModel(AuthorModel authorModel) {
        this.authorModel = authorModel;
        return this;
    }
}
