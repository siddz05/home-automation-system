package com.signz.homeautomation.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author siddharthdwivedi
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "com.signz.homeautomation.repository")
@EntityScan("com.signz.homeautomation.model")
public class AppConfig {

    /**
     * @param configurer
     * @implNote setting default response type to json
     */
  /*  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
    }*/
}
