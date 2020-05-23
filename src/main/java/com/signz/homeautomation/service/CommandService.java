package com.signz.homeautomation.service;

import com.signz.homeautomation.command.MasterCommand;
import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.exception.UnsupportedCommandException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;

import java.util.List;

/**
 * @author siddharthdwivedi
 */
public interface CommandService {

    /**
     * @param Command
     * @return
     */
    Command addCommand(Command Command);

    /**
     * @param Command
     * @return
     */
    Command updateCommand(Command Command) throws CommandNotFoundException;

    /**
     * @param CommandId
     * @return
     */
    Integer deleteCommand(Integer CommandId) throws CommandNotFoundException;

    /**
     * @param CommandId
     * @return
     */
    Command getCommandById(Integer CommandId) throws CommandNotFoundException;

    /**
     * @return
     */
    List<Command> getAllCommand();

    /**
     * @param device
     * @param commandId
     * @return
     */
    MasterCommand buildCommand(Device device, Integer commandId) throws DeviceNotFoundException, UnsupportedCommandException;

    /**
     * @param command
     */
    String executeCommand(MasterCommand command);

}
