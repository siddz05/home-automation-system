package com.signz.homeautomation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String deviceCommand;
    @ManyToOne
    @JoinColumn//(name = "device_id")
    Device device;

}
