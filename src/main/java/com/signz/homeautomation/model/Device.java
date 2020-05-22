package com.signz.homeautomation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Device {

    @Id
    private Integer id;
    private String deviceName;

    @ManyToOne
    @JoinColumn//(name = "home_id")
    private Home home;

    @OneToMany(mappedBy = "device")
    Set<Command> commandSet;

    void addCommand(Command command) {
        commandSet.add(command);
        command.setDevice(this);
    }

    void removeCommand(Command command) {
        commandSet.remove(command);
        command.setDevice(null);
    }


}