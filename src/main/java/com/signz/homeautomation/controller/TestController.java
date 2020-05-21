package com.signz.homeautomation.controller;

import com.signz.homeautomation.exception.DeviceNotFoundException;
import com.signz.homeautomation.utility.response.ApiResponse;
import com.signz.homeautomation.utility.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/exc")
    public String testExceptionHandler(HttpServletResponse res) throws Exception {
        throw new DeviceNotFoundException("Sid is Throwing Exception");
    }

    @GetMapping(value = "/res")
    public BaseResponse<Map> apiResponseTest(HttpServletResponse res) throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("name", "sid");
        return new ApiResponse<>(res, 200, result, "Success Data");
    }
}
