package com.epam;

import com.epam.components.ApplicationContextHolder;
import com.epam.interfaces.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class, args);

        final ApplicationContext context = ApplicationContextHolder.getApplicationContext();

        context.getBean(GameService.class).play();


    }
}
