package com.signz.homeautomation.controller;

import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;
import com.signz.homeautomation.service.DeviceService;
import com.signz.homeautomation.service.HomeService;
import com.signz.homeautomation.utility.response.ApiResponse;
import com.signz.homeautomation.utility.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    /**
     * @param res
     * @param device
     * @return Device
     * @throws Exception
     **/

    @PostMapping()
    BaseResponse<Device> addNewDevice(HttpServletResponse res, @RequestBody Device device) {
        Device deviceData = deviceService.addDevice(device);
        return new ApiResponse<>(res, deviceData);
    }

    /**
     * @param res
     * @param deviceId
     * @return
     * @throws DeviceNotFoundException
     */
    @GetMapping("/{device-id}")
    BaseResponse<Device> getDeviceById(HttpServletResponse res, @PathVariable("device-id") Integer deviceId) throws DeviceNotFoundException {
        Device device = deviceService.getDeviceById(deviceId);
        return new ApiResponse<>(res, device);
    }

    /**
     * @param res
     * @param deviceId
     * @return
     * @throws DeviceNotFoundException
     */
    @DeleteMapping("/{device-id}")
    BaseResponse<Integer> deleteHomeById(HttpServletResponse res, @PathVariable("device-id") Integer deviceId) throws DeviceNotFoundException {
        Integer device = deviceService.deleteDevice(deviceId);
        return new ApiResponse<>(res, device);
    }


    /**
     * @param res
     * @return
     * @throws Exception
     */
    @GetMapping()
    BaseResponse<List<Device>> getAllHome(HttpServletResponse res) throws Exception {
        List<Device> deviceList = deviceService.getAllDevice();
        return new ApiResponse<>(res, deviceList);
    }

    /**
     * @param res
     * @param deviceId
     * @param command
     * @return
     * @throws DeviceNotFoundException
     */
    @PutMapping("/{device-id}/command")
    BaseResponse<Device> addCommandInDevice(HttpServletResponse res, @PathVariable("device-id") Integer deviceId, @RequestBody Command command) throws DeviceNotFoundException {
        Device deviceData = deviceService.addCommandInDevice(command, deviceId);
        return new ApiResponse<>(res, deviceData);
    }

    @DeleteMapping("/{device-id}/command")
    BaseResponse<Device> removeCommandFromDevice(HttpServletResponse res, @PathVariable("device-id") Integer deviceId, @RequestBody Command command) throws DeviceNotFoundException {
        Device deviceData = deviceService.removeCommandInDevice(command, deviceId);
        return new ApiResponse<>(res, deviceData);
    }

}
