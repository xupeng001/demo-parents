package org.sample.portal;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@EnableScheduling
@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties
@ImportResource({ "classpath:application-context.xml" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
