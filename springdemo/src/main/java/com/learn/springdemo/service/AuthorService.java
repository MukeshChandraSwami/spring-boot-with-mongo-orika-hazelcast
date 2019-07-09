package com.learn.springdemo.service;

import com.learn.springdemo.constants.ErrorMsg;
import com.learn.springdemo.constants.ErrorResponseCode;
import com.learn.springdemo.constants.SuccessMsg;
import com.learn.springdemo.constants.SuccessResponseCode;
import com.learn.springdemo.entity.AuthorEO;
import com.learn.springdemo.repo.AuthorRepo;
import com.learn.springdemo.response.AuthorResponse;
import com.learn.springdemo.utils.OrikaGlobalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public AuthorResponse getAuthorById(String id){
        AuthorResponse response = null;

        Optional<AuthorEO> authorEO = authorRepo.findById(id);
        if(authorEO.isPresent()){
            OrikaGlobalMapper mapper = new OrikaGlobalMapper(authorEO.get(), AuthorResponse.class);
            response = (AuthorResponse)mapper.map();
            response.setSuccess(true);
            response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_AVAILABLE);
            response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_AVAILABLE);
        }else{
            response = new AuthorResponse();
            response.setResponseCode(ErrorResponseCode.ERROR_AUTHOR_NOT_AVAILABLE);
            response.setResponseMsg(ErrorMsg.ERROR_MSG_AUTHOR_NOT_FOUND);
        }
        return response;
    }

    public AuthorResponse addAuthor(AuthorEO author) {
        AuthorResponse response = null;
        AuthorEO savedAuthor = authorRepo.save(author);

        if(savedAuthor != null){
            OrikaGlobalMapper mapper = new OrikaGlobalMapper(savedAuthor, AuthorResponse.class);
            response = (AuthorResponse)mapper.map();
            response.setSuccess(true);
            response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_ADDED);
            response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_ADDED);
        }else{
            response = new AuthorResponse();
            response.setResponseCode(ErrorResponseCode.ERROR_AUTHOR_NOT_ADDED);
            response.setResponseMsg(ErrorMsg.ERROR_AUTHOR_NOT_ADDED);
        }
        return response;
    }
}
