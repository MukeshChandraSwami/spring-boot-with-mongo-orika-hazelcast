package com.learn.springmongo.constants;

public interface ErrorResponseCode {

    // Book
    int ERROR_BOOK_NOT_AVAILABLE = 401;
    int ERROR_BOOK_NOT_POSTED = 402;

    // Author
    int ERROR_AUTHOR_NOT_AVAILABLE = 421;
    int ERROR_AUTHOR_NOT_ADDED = 422;

    //Update
    int ERROR_AUTHOR_UPDATED = 461;

    //Purge
    int ERROR_AUTHOR_PURGE = 481;

}
