package com.signz.homeautomation.exception;

import com.signz.homeautomation.utility.response.ApiResponse;
import com.signz.homeautomation.utility.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@SuppressWarnings({"unchecked", "raw"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handelAllException(Exception ex, HttpServletResponse res) {

        List<String> detailList = new ArrayList<>();
        detailList.add(ex.getLocalizedMessage());
        BaseResponse<Object> error = new ApiResponse<>(res, INTERNAL_SERVER_ERROR.value(), detailList, "Something Went Wrong");
        return new ResponseEntity(error, INTERNAL_SERVER_ERROR);

    }

    /**
     * @param ex
     * @param res
     * @return
     */
    @ExceptionHandler(DeviceNotFoundException.class)
    public final ResponseEntity<Object> handelDeviceNotFoundException(DeviceNotFoundException ex, HttpServletResponse res) {
        List<String> detailList = new ArrayList<>();
        detailList.add(ex.getLocalizedMessage());

        BaseResponse<Object> error = new ApiResponse<>(res, HttpStatus.NOT_FOUND.value(), detailList, "Device Not Found");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    /**
     * @param ex
     * @param res
     * @return
     */
    @ExceptionHandler(HomeNotFoundException.class)
    public final ResponseEntity<Object> handelHomeNotFoundException(HomeNotFoundException ex, HttpServletResponse res) {
        List<String> detailList = new ArrayList<>();
        detailList.add(ex.getLocalizedMessage());

        BaseResponse<Object> error = new ApiResponse<>(res, HttpStatus.NOT_FOUND.value(), detailList, "No Home Found");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    /**
     * @param ex
     * @param res
     * @return
     */
    @ExceptionHandler(CommandNotFoundException.class)
    public final ResponseEntity<Object> handelCommandNotFoundException(CommandNotFoundException ex, HttpServletResponse res) {
        List<String> detailList = new ArrayList<>();
        detailList.add(ex.getLocalizedMessage());

        BaseResponse<Object> error = new ApiResponse<>(res, HttpStatus.NOT_FOUND.value(), detailList, "No Command Found");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


    /**
     * @param ex
     * @param res
     * @return
     */
    @ExceptionHandler(UnsupportedCommandException.class)
    public final ResponseEntity<Object> handelUnsupportedActionException(UnsupportedCommandException ex, HttpServletResponse res) {
        List<String> detailList = new ArrayList<>();
        detailList.add(ex.getLocalizedMessage());

        BaseResponse<Object> error = new ApiResponse<>(res, HttpStatus.NOT_FOUND.value(), detailList, "Sorry, Command Not Supported, for this device");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


}
