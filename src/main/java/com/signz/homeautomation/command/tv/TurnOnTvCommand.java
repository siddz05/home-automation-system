package com.signz.homeautomation.command.tv;

import com.signz.homeautomation.command.MasterCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnOnTvCommand implements MasterCommand {

    Tv tv;

    /**
     * This, Will Executed by all the Command Classes
     */
    @Override
    public String execute() {
        return tv.turnOnTv();
    }
}
