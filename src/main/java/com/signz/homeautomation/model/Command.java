package com.signz.homeautomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author siddharthdwivedi
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String deviceCommand;

    @JsonIgnore // to break infinite recursion, on output response
    @ManyToOne
    @JoinColumn(name = "device_id")
    Device device;

}
