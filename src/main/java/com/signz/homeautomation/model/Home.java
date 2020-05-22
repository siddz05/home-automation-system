package com.signz.homeautomation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Home {

    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "home")
    private Set<Device> deviceSet;

    void addDevice(Device device) {
        deviceSet.add(device);
        device.setHome(this);
    }

    void deleteDevice(Device device) {
        deviceSet.remove(device);
        device.setHome(null);
    }

}
