package com.signz.homeautomation.service;

import com.signz.homeautomation.model.Home;

import java.util.List;

public interface HomeService {

    Home addHome(Home home);

    Integer deleteHome(Integer home);

    Home getHomeById(Integer homeId);

    List<Home> getAllHome();
}
