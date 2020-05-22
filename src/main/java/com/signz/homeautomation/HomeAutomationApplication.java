package com.signz.homeautomation;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Log4j2
public class HomeAutomationApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomeAutomationApplication.class, args);
        log.info("Home Automation System Server Started ");
    }


}
