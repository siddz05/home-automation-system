package com.signz.homeautomation.service;

import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.signz.homeautomation.utility.Utility.isNull;

/**
 * @author siddharthdwivedi
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;


    /**
     * @param device
     * @return
     */
    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    /**
     * @param device
     * @return
     */
    @Override
    public Device updateDevice(Device device) throws DeviceNotFoundException {
        Device deviceData = getDeviceById(device.getId());

        if (!deviceData.getDeviceName().isEmpty()) deviceData.setDeviceName(device.getDeviceName());
        if (!deviceData.getCommandSet().isEmpty()) deviceData.setCommandSet(device.getCommandSet());

        return deviceRepository.save(deviceData);
    }

    /**
     * @param deviceId
     * @return
     */
    @Override
    public Integer deleteDevice(Integer deviceId) throws DeviceNotFoundException {
        getDeviceById(deviceId);
        deviceRepository.deleteById(deviceId);
        return deviceId;
    }

    /**
     * @param deviceId
     * @return
     */
    @Override
    public Device getDeviceById(Integer deviceId) throws DeviceNotFoundException {
        Optional<Device> device = deviceRepository.findById(deviceId);

        if (!device.isPresent()) throw new DeviceNotFoundException("No Device Found");

        return device.get();
    }

    /**
     * @return
     */
    @Override
    public List<Device> getAllDevice() {
        List<Device> deviceList = new ArrayList<>();
        deviceRepository.findAll().forEach(deviceList::add);
        return deviceList;
    }

    /**
     * @param command
     * @param deviceId
     * @return
     */
    @Override
    public Device addCommandInDevice(Command command, Integer deviceId) throws CommandNotFoundException, DeviceNotFoundException {
        if (isNull(command)) {
            throw new CommandNotFoundException("No Command Found");
        }
        Device device = getDeviceById(deviceId);
        device.addCommand(command);
        deviceRepository.save(device);
        return device;
    }

    /**
     * @param command
     * @param deviceId
     * @return
     */
    @Override
    public Device removeCommandInDevice(Command command, Integer deviceId) throws CommandNotFoundException, DeviceNotFoundException {
        if (isNull(command)) {
            throw new CommandNotFoundException("No Command Found");
        }
        Device device = getDeviceById(deviceId);
        device.removeCommand(command);
        deviceRepository.save(device);
        return device;
    }
}
