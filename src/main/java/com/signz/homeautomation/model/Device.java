package com.signz.homeautomation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
