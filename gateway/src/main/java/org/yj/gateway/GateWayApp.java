package org.yj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GateWayApp
{

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GateWayApp.class, args);
    }
}
