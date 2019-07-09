package com.learn.springmongo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ActiveProfileService {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${msg}")
    private String msg;

    public String getActiveProfile(){
        return activeProfile;
    }

    public String getMsg(){
        return msg;
    }
}
