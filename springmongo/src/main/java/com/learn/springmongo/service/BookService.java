package com.learn.springmongo.service;

import com.learn.springmongo.constants.ErrorMsg;
import com.learn.springmongo.constants.ErrorResponseCode;
import com.learn.springmongo.constants.SuccessMsg;
import com.learn.springmongo.constants.SuccessResponseCode;
import com.learn.springmongo.entity.BookEO;
import com.learn.springmongo.repo.BookRepo;
import com.learn.springmongo.response.BookResponse;
import com.learn.springmongo.utils.OrikaGlobalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookResponse getBookById(String bookId){
        BookResponse response = null;
        Optional<BookEO> bookEO = bookRepo.findById(bookId);
        if(bookEO.isPresent()){
            OrikaGlobalMapper mapper = new OrikaGlobalMapper(bookEO.get(),BookResponse.class);
            response = (BookResponse)mapper.map();
            response.setSuccess(true);
            response.setResponseMsg(SuccessMsg.SUCCESS_BOOK_AVAILABLE);
            response.setResponseCode(SuccessResponseCode.SUCCESS_BOOK_AVAILABLE);
        }else{
            response = new BookResponse();
            response.setResponseMsg(ErrorMsg.ERROR_MSG_BOOK_NOT_FOUND);
            response.setResponseCode(ErrorResponseCode.ERROR_BOOK_NOT_AVAILABLE);
        }
        return response;
    }

    public BookResponse postBook(BookEO book){
        BookEO savedBook = (BookEO)bookRepo.save(book);

        BookResponse response = null;
       if(savedBook != null){
           OrikaGlobalMapper mapper = new OrikaGlobalMapper(savedBook,BookResponse.class);
           response = (BookResponse)mapper.map();
           response.setSuccess(true);
           response.setResponseMsg(SuccessMsg.SUCCESS_BOOK_POSTED);
           response.setResponseCode(SuccessResponseCode.SUCCESS_BOOK_POSTED);
       }else{
           response = new BookResponse();
           response.setResponseMsg(ErrorMsg.ERROR_BOOK_NOT_POSTED);
           response.setResponseCode(ErrorResponseCode.ERROR_BOOK_NOT_POSTED);
       }

       return response;
    }
}
