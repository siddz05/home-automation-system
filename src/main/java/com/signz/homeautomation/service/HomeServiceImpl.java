package com.signz.homeautomation.service;

import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.exception.HomeNotFoundException;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;
import com.signz.homeautomation.repository.HomeRepository;
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
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;

    @Autowired
    DeviceService deviceService;

    /**
     * @param home
     * @return
     */
    @Override
    public Home addHome(Home home) {
        return homeRepository.save(home);
    }

    /**
     * @param homeId
     * @return
     */
    @Override
    public Integer deleteHome(Integer homeId) throws HomeNotFoundException {
        getHomeById(homeId);
        homeRepository.deleteById(homeId);
        return homeId;
    }

    /**
     * @param homeId
     * @return
     */
    @Override
    public Home getHomeById(Integer homeId) throws HomeNotFoundException {

        Optional<Home> home = homeRepository.findById(homeId);

        if (!home.isPresent()) {
            throw new HomeNotFoundException("No Home Found For The given Id");
        }
        return home.get();
    }

    /**
     * @return
     */
    @Override
    public List<Home> getAllHome() {
        List<Home> homeList = new ArrayList<>();
        homeRepository.findAll().forEach(homeList::add);
        return homeList;
    }

    /**
     * @param device
     * @param homeId
     * @return
     */
    @Override
    public Home addDeviceInHome(Device device, Integer homeId) throws HomeNotFoundException, DeviceNotFoundException {
        if (isNull(device)) {
            throw new DeviceNotFoundException("No Device Found");
        }

        Device deviceSaved = deviceService.addDevice(device);

        Home home = getHomeById(homeId);
        home.addDevice(deviceSaved);
        homeRepository.save(home);
        return home;
    }

    /**
     * @param deviceId
     * @param homeId
     * @return
     */
    @Override
    public Home removeDeviceFromHome(Integer deviceId, Integer homeId) {
        Device device = deviceService.getDeviceById(deviceId);
        if (isNull(device)) {
            throw new DeviceNotFoundException("No Device Found");
        }
        Home home = getHomeById(homeId);
        home.removeDevice(device);
        homeRepository.save(home);
        return home;
    }
}
