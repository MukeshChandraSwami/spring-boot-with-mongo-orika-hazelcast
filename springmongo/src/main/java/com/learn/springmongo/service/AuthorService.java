package com.learn.springmongo.service;

import com.learn.springmongo.constants.*;
import com.learn.springmongo.entity.AuthorEO;
import com.learn.springmongo.model.AuthorModel;
import com.learn.springmongo.repo.AuthorRepo;
import com.learn.springmongo.response.AuthorResponse;
import com.learn.springmongo.response.CountResponse;
import com.learn.springmongo.response.PurgeResponse;
import com.learn.springmongo.response.Response;
import com.learn.springmongo.utils.OrikaGlobalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Cacheable(value = {GenericConstants.AUTHOR_BY_ID_CACHE}, key="#id")
    public Response getAuthorById(String id) {
        AuthorResponse response = new AuthorResponse();

        Optional<AuthorEO> authorEO = authorRepo.findById(id);
        if (authorEO.isPresent()) {
            OrikaGlobalMapper mapper = new OrikaGlobalMapper(authorEO.get(), AuthorModel.class);
            AuthorModel authorModel = (AuthorModel) mapper.map();
            response.setSuccess(true);
            response.setAuthorModel(authorModel);
            response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_AVAILABLE);
            response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_AVAILABLE);
        } else {
            response.setResponseCode(ErrorResponseCode.ERROR_AUTHOR_NOT_AVAILABLE);
            response.setResponseMsg(ErrorMsg.ERROR_MSG_AUTHOR_NOT_FOUND);
        }
        return response;
    }

    public Response addAuthor(AuthorEO author) {
        AuthorResponse response = null;

        authorRepo.save(author);

        OrikaGlobalMapper mapper = new OrikaGlobalMapper(author, AuthorModel.class);

        AuthorModel authorModel = (AuthorModel) mapper.map();
        response.setSuccess(true);
        response.setAuthorModel(authorModel);
        response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_ADDED);
        response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_ADDED);

        return response;
    }

    public Response getTotalAuthors() {

       long count = authorRepo.getTotalAuthors();
       return new CountResponse(count,true,SuccessMsg.SUCCESS_AUTHOR_COUNT,SuccessResponseCode.SUCCESS_AUTHOR_COUNT);
    }

    @CachePut(value = {GenericConstants.AUTHOR_BY_ID_CACHE, GenericConstants.AUTHOR_CACHE_ALL, GenericConstants.AUTHOR_BY_ID_LIST_CACHE}, key = "#id")
    public Response updateAuthor(AuthorEO author, String id) {
        AuthorResponse response = null;

        long updateCount = authorRepo.updateAuthor(author, id);

        if(updateCount > 0){

            response = (AuthorResponse)getAuthorById(id);
            response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_UPDATED);
            response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_UPDATED);
        } else {
            response = new AuthorResponse();
            response.setResponseMsg(ErrorMsg.ERROR_AUTHOR_UPDATED);
            response.setResponseCode(ErrorResponseCode.ERROR_AUTHOR_UPDATED);
        }
        return response;
    }

    @CacheEvict(value = {GenericConstants.AUTHOR_BY_ID_CACHE, GenericConstants.AUTHOR_CACHE_ALL, GenericConstants.AUTHOR_BY_ID_LIST_CACHE}, key = "#id")
    public Response purgeAuthor(String id) {

        PurgeResponse response = new PurgeResponse();
        long purgeCount = authorRepo.purgeAuthor(id);
        if(purgeCount > 0){
            response.setSuccess(true);
            response.setResponseMsg(SuccessMsg.SUCCESS_AUTHOR_PURGE);
            response.setResponseCode(SuccessResponseCode.SUCCESS_AUTHOR_PURGE);
        }else{
            response.setResponseCode(ErrorResponseCode.ERROR_AUTHOR_PURGE);
            response.setResponseMsg(ErrorMsg.ERROR_AUTHOR_PURGE);
        }
        return  response;
    }
}
