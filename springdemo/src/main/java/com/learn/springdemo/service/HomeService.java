package com.learn.springdemo.service;

import com.learn.springdemo.model.HomeModel;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public HomeModel getHomeDetails(){

        return new HomeModel();
    }
}
