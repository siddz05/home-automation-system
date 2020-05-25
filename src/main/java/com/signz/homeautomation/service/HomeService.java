package com.signz.homeautomation.service;

import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.exception.HomeNotFoundException;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;

import java.util.List;

public interface HomeService {

    /*
    Home CRUD
    * */

    /**
     * @param home
     * @return
     */
    Home addHome(Home home);

    /**
     * @param home
     * @return
     */
    Integer deleteHome(Integer home) throws HomeNotFoundException;

    /**
     * @param homeId
     * @return
     */
    Home getHomeById(Integer homeId) throws HomeNotFoundException;

    /**
     * @return
     */
    List<Home> getAllHome();


    /*
    Device Add / Remove
    * */

    /**
     * @param device
     * @param homeId
     * @return
     */
    Home addDeviceInHome(Device device, Integer homeId) throws HomeNotFoundException, DeviceNotFoundException;

    /**
     * @param device
     * @param homeId
     * @return
     */
    Home removeDeviceFromHome(Integer deviceId, Integer homeId) throws HomeNotFoundException, DeviceNotFoundException;

}
