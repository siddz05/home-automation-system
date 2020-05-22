package com.signz.homeautomation.service;

import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;

import java.util.List;

public interface DeviceService {

    Device addDeviceForHome(Device device, Integer homeId);

    Integer deleteDevice(Integer deviceId, Home homeId);

    Home getDeviceById(Integer deviceId);

    List<Device> getAllDevice();

}
