package com.signz.homeautomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String deviceName;

    @JsonIgnore // to break infinite recursion, on output response
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)//cascade.ALL to persiste parent ID
    Set<Command> commandSet;

    public void addCommand(Command command) {
        commandSet.add(command);
        command.setDevice(this);
    }

    public void removeCommand(Command command) {
        commandSet.remove(command);
        command.setDevice(null);
    }


}
