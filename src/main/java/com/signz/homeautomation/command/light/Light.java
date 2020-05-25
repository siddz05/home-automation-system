package com.signz.homeautomation.command.light;

import static com.signz.homeautomation.utility.Utility.print;

/**
 * One of the reciver Class
 */
public class Light {

    enum SupportedCommands{
        TURN_ON,
        TURN_OFF,
    }

    public String turnOn() {
        print("Light On");
        return "LIGHT IS NOW ON!!!";
    }

    public String turnOff() {
        print("Light Off");
        return "LIGHT IS NOW OFF!!!";
    }
}