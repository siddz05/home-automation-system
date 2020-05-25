package com.signz.homeautomation.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL,  orphanRemoval = true)
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
