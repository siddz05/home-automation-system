package com.signz.homeautomation.command.invoker;

import com.signz.homeautomation.command.MasterCommand;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class DeviceCommandInvoker {

    @Setter
    MasterCommand command;

    public String invokeCommand() {
        return command.execute();
    }

}
