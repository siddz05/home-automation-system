package com.signz.homeautomation;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@RequestMapping
@RestController
@Log4j2
public class HomeAutomationApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomeAutomationApplication.class, args);
        log.info("Home Automation System Server Started ");
    }

    @GetMapping(value = {"/heath-check", "/"})
    public String healthCheck() {
        return "Home Automation System Is Up & Running !";
    }

}
