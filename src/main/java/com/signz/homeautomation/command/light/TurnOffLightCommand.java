package com.signz.homeautomation.command.light;

import com.signz.homeautomation.command.MasterCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnOffLightCommand implements MasterCommand {

    Light light;

    /**
     * This, Will Executed by all the Command Classes
     */
    @Override
    public String execute() {
        return light.turnOff();
    }
}
