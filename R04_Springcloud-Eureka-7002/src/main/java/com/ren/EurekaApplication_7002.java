package com.ren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // EnableEurekaServer服务端的启动类，可以测试一下
public class EurekaApplication_7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_7002.class, args);
    }

}
