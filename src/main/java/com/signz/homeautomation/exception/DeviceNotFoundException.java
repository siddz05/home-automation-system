package com.signz.homeautomation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author siddharthdwivedi
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeviceNotFoundException extends RuntimeException{

    public DeviceNotFoundException(String execption){
        super(execption);
    }

}
