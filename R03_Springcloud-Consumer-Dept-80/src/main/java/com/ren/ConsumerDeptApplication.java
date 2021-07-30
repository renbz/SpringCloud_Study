package com.ren;

import com.ren.myrule.RenRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 在微服务启动时 就能加载自定义的Ribbon类
//@RibbonClient(name = "SPRINGLOUD-PROVIDER-DEPT",configuration = RenRule.class)
public class ConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptApplication.class, args);
    }

}
