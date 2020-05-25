package com.signz.homeautomation.command.light;

import static com.signz.homeautomation.utility.Utility.print;

/**
 * @author siddharthdwivedi
 * One of the reciver Class
 */
public class Light {


    public String turnOn() {
        print("Light On");
        return "LIGHT IS NOW ON!!!";
    }

    public String turnOff() {
        print("Light Off");
        return "LIGHT IS NOW OFF!!!";
    }
}
