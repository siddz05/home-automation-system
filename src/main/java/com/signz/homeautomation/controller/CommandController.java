package com.signz.homeautomation.controller;

import com.signz.homeautomation.exception.CommandNotFoundException;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.model.Command;
import com.signz.homeautomation.service.CommandService;
import com.signz.homeautomation.service.CommandService;
import com.signz.homeautomation.utility.response.ApiResponse;
import com.signz.homeautomation.utility.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.signz.homeautomation.utility.Constants.PRODUCES;

/**
 * @author siddharthdwivedi
 *
 */
@ApiIgnore
@RestController
@RequestMapping(value = "/command", produces = PRODUCES)
public class CommandController {

    @Autowired
    CommandService commandService;

    /**
     * @param res
     * @param command
     * @return Command
     * @throws Exception
     **/

    @PostMapping()
    BaseResponse<Command> addNewCommand(HttpServletResponse res, @RequestBody Command command) {
        Command commandData = commandService.addCommand(command);
        return new ApiResponse<>(res, commandData);
    }

    /**
     * @param res
     * @param CommandId
     * @return
     * @throws CommandNotFoundException
     */
    @GetMapping("/{command-id}")
    BaseResponse<Command> getCommandById(HttpServletResponse res, @PathVariable("command-id") Integer CommandId) throws CommandNotFoundException {
        Command device = commandService.getCommandById(CommandId);
        return new ApiResponse<>(res, device);
    }

    /**
     * @param res
     * @param CommandId
     * @return
     * @throws CommandNotFoundException
     */
    @DeleteMapping("/{command-id}")
    BaseResponse<Integer> deleteHomeById(HttpServletResponse res, @PathVariable("command-id") Integer CommandId) throws CommandNotFoundException {
        Integer device = commandService.deleteCommand(CommandId);
        return new ApiResponse<>(res, device);
    }


    /**
     * @param res
     * @return
     * @throws Exception
     */
    @GetMapping()
    BaseResponse<List<Command>> getAllCommand(HttpServletResponse res) throws Exception {
        List<Command> deviceList = commandService.getAllCommand();
        return new ApiResponse<>(res, deviceList);
    }

}
