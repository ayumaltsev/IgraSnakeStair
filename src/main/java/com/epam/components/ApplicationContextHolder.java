package com.epam.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextHolder {

    private static ApplicationContext context;

    @Autowired
    public ApplicationContextHolder(ApplicationContext applicationContext) {
        ApplicationContextHolder.context = applicationContext;

    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

}
