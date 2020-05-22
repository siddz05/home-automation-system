package com.signz.homeautomation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Command {

    @Id
    private Integer id;
    private String deviceCommand;
    @ManyToOne
    @JoinColumn//(name = "device_id")
    Device device;

}
