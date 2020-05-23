package com.signz.homeautomation.service;

import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandServiceImpl implements CommandService {

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
}
