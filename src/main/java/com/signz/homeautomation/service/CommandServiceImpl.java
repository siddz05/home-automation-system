package com.signz.homeautomation.service;

import com.signz.homeautomation.command.MasterCommand;
import com.signz.homeautomation.command.invoker.DeviceCommandInvoker;
import com.signz.homeautomation.command.light.Light;
import com.signz.homeautomation.command.light.TurnOffLightCommand;
import com.signz.homeautomation.command.light.TurnOnLightCommand;
import com.signz.homeautomation.command.tv.*;
import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.exception.UnsupportedCommandException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.repository.CommandRepository;
import com.signz.homeautomation.utility.enumconstants.SupportedDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author siddharthdwivedi
 */
@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    DeviceCommandInvoker deviceCommandInvoker;

    @Autowired
    CommandRepository commandRepository;

    /**
     * @param command
     * @return
     */
    @Override
    public Command addCommand(Command command) {
        return commandRepository.save(command);
    }

    /**
     * @param command
     * @return
     */
    @Override
    public Command updateCommand(Command command) throws CommandNotFoundException {
        Command commandData = getCommandById(command.getId());

        if (!command.getDeviceCommand().isEmpty()) commandData.setDeviceCommand(command.getDeviceCommand());

        return commandRepository.save(commandData);
    }

    /**
     * @param commandId
     * @return
     */
    @Override
    public Integer deleteCommand(Integer commandId) throws CommandNotFoundException {
        getCommandById(commandId);
        commandRepository.deleteById(commandId);
        return commandId;
    }

    /**
     * @param commandId
     * @return
     */
    @Override
    public Command getCommandById(Integer commandId) throws CommandNotFoundException {
        Optional<Command> command = commandRepository.findById(commandId);

        if (!command.isPresent()) throw new CommandNotFoundException("No Command Found");

        return command.get();
    }

    /**
     * @return
     */
    @Override
    public List<Command> getAllCommand() {
        List<Command> commandList = new ArrayList<>();
        commandRepository.findAll().forEach(commandList::add);
        return commandList;
    }

    @Override
    public String executeCommand(MasterCommand command) {
        deviceCommandInvoker.setCommand(command);
        return deviceCommandInvoker.invokeCommand();
    }

    /**
     * @param device
     * @param commandId
     * @return
     */
    @Override
    public MasterCommand buildCommand(Device device, Integer commandId) throws DeviceNotFoundException, UnsupportedCommandException {
        MasterCommand command = null;
        Command commandObj = getCommandById(commandId);
        String commandName = commandObj.getDeviceCommand();
        String d = device.getDeviceName();
        SupportedDevice deviceName = SupportedDevice.getDeviceByValue(d);

        try {
            SupportedDevice abc = SupportedDevice.valueOf("FAN");
            System.out.println(abc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (deviceName) {
            case LIGHT:
                command = getCommandForLight(command, commandName);
                break;
            case TV:
                command = getCommandForTv(command, commandName);
                break;
            default:
                throw new DeviceNotFoundException("No Device found");
        }
        return command;
    }

    private MasterCommand getCommandForTv(MasterCommand command, String commandName) {
        Tv tv = new Tv();

        switch (commandName) {
            case "turnOn":
                command = new TurnOnTvCommand(tv);
                break;
            case "turnOff":
                command = new TurnOffTvCommand(tv);
                break;
            case "changeChannel":
                command = new ChangeChannelTvCommand(tv);
                break;
            case "changeVolume":
                command = new ChangeVolumeTvCommand(tv);
                break;
            default:
                throw new UnsupportedCommandException("Command Not Supported");
        }
        return command;
    }

    private MasterCommand getCommandForLight(MasterCommand command, String commandName) {
        Light light = new Light();
        switch (commandName) {
            case "turnOn":
                command = new TurnOnLightCommand(light);
                break;
            case "turnOff":
                command = new TurnOffLightCommand(light);
                break;
            default:
                throw new UnsupportedCommandException("Command Not Supported");
        }
        return command;
    }
}
