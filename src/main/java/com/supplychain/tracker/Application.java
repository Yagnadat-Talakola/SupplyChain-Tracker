package com.supplychain.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //Bootstraps and launch spring application.
        ApplicationContext context = SpringApplication.run(Application.class, args);

    }

}
