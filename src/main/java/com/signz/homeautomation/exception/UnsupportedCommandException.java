package com.signz.homeautomation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author siddharthdwivedi
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class UnsupportedCommandException extends RuntimeException{

    public UnsupportedCommandException(String execption){
        super(execption);
    }

}
