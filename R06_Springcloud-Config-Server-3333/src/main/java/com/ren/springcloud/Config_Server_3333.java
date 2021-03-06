package com.ren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Ren
 */

@SpringBootApplication
@EnableConfigServer
public class Config_Server_3333 {

    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3333.class,args);
    }
}
