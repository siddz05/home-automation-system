package com.signz.homeautomation.controller;

import com.signz.homeautomation.exception.HomeNotFoundException;
import com.signz.homeautomation.model.Device;
import com.signz.homeautomation.model.Home;
import com.signz.homeautomation.service.HomeService;
import com.signz.homeautomation.utility.response.ApiResponse;
import com.signz.homeautomation.utility.response.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.signz.homeautomation.utility.Constants.PRODUCES;

/**
 * @author siddharthdwivedi
 */
//@Api(value = "Content Api", tags = "content-api")
@RestController
@RequestMapping(value = "/home", produces = PRODUCES)
public class HomeController {

    @Autowired
    HomeService homeService;

    /**
     * @param res
     * @param home
     * @return Home
     * @throws Exception
     **/

    @PostMapping()
    BaseResponse<Home> addNewHome(HttpServletResponse res, @RequestBody Home home) throws Exception {
        Home homeData = homeService.addHome(home);
        return new ApiResponse<>(res, homeData);
    }

    @GetMapping("/{home-id}")
    BaseResponse<Home> getHomeById(HttpServletResponse res, @PathVariable("home-id") Integer homeId) throws HomeNotFoundException {
        Home homeData = homeService.getHomeById(homeId);
        return new ApiResponse<>(res, homeData);
    }

    @DeleteMapping("/{home-id}")
    BaseResponse<Integer> deleteHomeById(HttpServletResponse res, @PathVariable("home-id") Integer homeId) throws HomeNotFoundException {
        Integer homeData = homeService.deleteHome(homeId);
        return new ApiResponse<>(res, homeData);
    }


    @GetMapping("")
    @io.swagger.annotations.ApiResponse(code = 200, message = "All Conected Home", response = Home.class)
    BaseResponse<List<Home>> getAllHome(HttpServletResponse res) throws Exception {
        List<Home> homeData = homeService.getAllHome();
        return new ApiResponse<>(res, homeData);
    }

    @PutMapping("/{home-id}/device")
    BaseResponse<Home> addDeviceInHome(HttpServletResponse res, @PathVariable("home-id") Integer homeId, @RequestBody Device device) throws Exception {
        Home homeData = homeService.addDeviceInHome(device, homeId);
        return new ApiResponse<>(res, homeData);
    }

    @DeleteMapping("/{home-id}/device/{device-id}")
    BaseResponse<Home> removeDeviceFromHome(HttpServletResponse res, @PathVariable("home-id") Integer homeId, @PathVariable("device-id") Integer deviceId) throws Exception {
        Home homeData = homeService.removeDeviceFromHome(deviceId, homeId);
        return new ApiResponse<>(res, homeData);
    }


}
