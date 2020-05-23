package com.signz.homeautomation.service;

import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class RawDataIngestionService implements CommandLineRunner {

    @Autowired
    HomeService homeService;

    @Autowired
    DeviceService deviceService;


    void addHomeRawData() {
        int constant = 3;
        for (int i = 1; i < constant; i++) {
            Home home = new Home();
            home.setName("Home " + i);
            homeService.addHome(home);
        }
    }

    void addDeviceToHome() {

        homeService.getAllHome().forEach(home -> {

            Device device = new Device();
            device.setDeviceName("light");
            homeService.addDeviceInHome(device, home.getId());


        });
    }

    void addCommandToDevice() {
        deviceService.getAllDevice().forEach(device -> {

            Command c = new Command();
            c.setDeviceCommand("turnOn");
            deviceService.addCommandInDevice(c, device.getId());
            c = new Command();
            c.setDeviceCommand("turnOff");
            deviceService.addCommandInDevice(c, device.getId());


        });

    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        addHomeRawData();
        addDeviceToHome();
        addCommandToDevice();
    }
}
