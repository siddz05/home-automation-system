package com.signz.homeautomation.command.light;

import com.signz.homeautomation.command.MasterCommand;

/**
 * @implNote All the Light Commands Summarized at one place.
 */
public interface LightCommands extends MasterCommand {

    /**
     * @implNote turn on light
     */
    void turnOn();

    /**
     * @implNote disco lights
     */
    void switchToDiscoMode();

    /**
     *  @implNote turn off light
     */
    void turnOff();
}
