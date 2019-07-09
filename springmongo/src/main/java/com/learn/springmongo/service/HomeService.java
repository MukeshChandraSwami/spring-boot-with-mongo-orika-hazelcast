package com.learn.springmongo.service;

import com.learn.springmongo.model.HomeModel;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public HomeModel getHomeDetails(){

        return new HomeModel();
    }
}
