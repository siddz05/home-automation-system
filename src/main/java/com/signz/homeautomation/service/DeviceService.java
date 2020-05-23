package com.signz.homeautomation.service;

import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;

import java.util.List;

/**
 * @author siddharthdwivedi
 */
public interface DeviceService {

    /**
     * @param device
     * @return
     */
    Device addDevice(Device device);

    /**
     * @param device
     * @return
     */
    Device updateDevice(Device device) throws DeviceNotFoundException;

    /**
     * @param deviceId
     * @return
     */
    Integer deleteDevice(Integer deviceId) throws DeviceNotFoundException;

    /**
     * @param deviceId
     * @return
     */
    Device getDeviceById(Integer deviceId) throws DeviceNotFoundException;

    /**
     * @return
     */
    List<Device> getAllDevice();

    /**
     * @param command
     * @param deviceId
     * @return
     */
    Device addCommandInDevice(Command command, Integer deviceId) throws CommandNotFoundException, DeviceNotFoundException;

    /**
     * @param command
     * @param deviceId
     * @return
     */
    Device removeCommandInDevice(Command command, Integer deviceId) throws CommandNotFoundException, DeviceNotFoundException;
}
