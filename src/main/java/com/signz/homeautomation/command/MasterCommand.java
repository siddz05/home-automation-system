package com.signz.homeautomation.command;

/**
 * @author siddharthdwivedi
 * @Impl Master Command Interface, helpus controll all the commands.
 */
@FunctionalInterface
public interface MasterCommand {

    /**
     * This, Will Executed by all the Command Classes
     */
    String execute();

}
