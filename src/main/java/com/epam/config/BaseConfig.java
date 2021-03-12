package com.epam.config;

import com.epam.components.PlayerImpl;
import com.epam.interfaces.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
@ComponentScan("com.epam")
public class BaseConfig {

    @Bean
    public Random random() {
        return new Random();
    }


    //I prefer to collect all prototype-scope beans in Java-configs

    @Bean
    @Scope("prototype")
    public Player player() {
        return new PlayerImpl();
    }

}