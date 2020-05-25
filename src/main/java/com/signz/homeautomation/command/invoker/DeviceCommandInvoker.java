package com.signz.homeautomation.command.invoker;

import com.signz.homeautomation.command.MasterCommand;
import lombok.Setter;
import org.springframework.stereotype.Component;


/**
 * @author siddharthdwivedi
 */
@Component
public class DeviceCommandInvoker {

    @Setter
    MasterCommand command;

    public String invokeCommand() {
        return command.execute();
    }

}
