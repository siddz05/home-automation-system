package com.signz.homeautomation.service;

import com.signz.homeautomation.command.MasterCommand;
import com.signz.homeautomation.command.invoker.DeviceCommandInvoker;
import com.signz.homeautomation.command.light.Light;
import com.signz.homeautomation.command.light.TurnOffLightCommand;
import com.signz.homeautomation.command.light.TurnOnLightCommand;
import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.exception.UnsupportedCommandException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.repository.CommandRepository;
import com.signz.homeautomation.utility.enumconstants.SUPPORTED_DEVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        //SUPPORTED_DEVICE deviceName = SUPPORTED_DEVICE.getEnum();

        switch (device.getDeviceName()) {

            case "light":
                Light light = new Light();
                String commandName = commandObj.getDeviceCommand();

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
                break;
            case "fan":
//                Fan fan = new Light();
//                String commandName = commandObj.getDeviceCommand();
//
//                switch (commandName) {
//                    case "TurnOn":
//                        command = new TurnOnLightCommand(light);
//                        break;
//                    case "TurnOff":
//                        command = new TurnOffLightCommand(light);
//                        break;
//                    default:
//                        throw new UnsupportedCommandException("Command Not Supported");
//                }
                break;
            default:
                throw new DeviceNotFoundException("No Device found");

        }
        return command;
    }
}
