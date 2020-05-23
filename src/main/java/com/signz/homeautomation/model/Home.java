package com.signz.homeautomation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "home")
    private Set<Device> deviceSet;

    public void addDevice(Device device) {
        deviceSet.add(device);
        device.setHome(this);
    }

    public void removeDevice(Device device) {
        deviceSet.remove(device);
        device.setHome(null);
    }

}
