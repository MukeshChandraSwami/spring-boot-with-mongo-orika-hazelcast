package com.learn.springmongo.constants;

public interface ErrorMsg {

    // Book
    String ERROR_MSG_BOOK_NOT_FOUND = "Requested book is not available";
    String ERROR_BOOK_NOT_POSTED = "Book is not posted";

    // Author
    String ERROR_MSG_AUTHOR_NOT_FOUND = "Requested author is not available";
    String ERROR_AUTHOR_NOT_ADDED = "Author is not added";
    String ERROR_AUTHOR_PURGE = "Not exists";
    String ERROR_AUTHOR_UPDATED = "Unable to update";
}
