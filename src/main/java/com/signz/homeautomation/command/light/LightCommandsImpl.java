package com.signz.homeautomation.command.light;

import com.signz.homeautomation.reciver.Light;

import static com.signz.homeautomation.utility.Utility.print;

/**
 * @implNote Encapsulating all the Light Related Commands Together.
 */
public class LightCommandsImpl implements LightCommands {

    Light light;

    /**
     * @implNote turn on light
     */
    @Override
    public void turnOn() {
        print("Turning Light On....");
    }

    /**
     * @implNote disco lights
     */
    @Override
    public void switchToDiscoMode() {
        print("Turning Light to Disco Mode...");
    }

    /**
     * @implNote turn off light
     */
    @Override
    public void turnOff() {
        print("Turning Light Off");
    }


    /**
     * This, Will Executed by all the Command Classes
     */
    @Override
    public void execute() {
        light.turnOn();
    }


   /* class TurnOffLightCommand implements MasterCommand {



        @Override
        public void execute() {

        }

    }*/


}
