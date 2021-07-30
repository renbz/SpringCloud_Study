package com.ren.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ren
 */

@Configuration
public class ConfigBean {  //@Configuration  -- spring  applicationContext.xml

    // IRule
    // RoundRobinRule  轮询
    // RandomRule      随机
    // RetryRule       会先按照轮询获取服务，如果服务获取失败，会在指定的时间内进行重试
    // AvailabilityFilteringRule : 会先过滤掉跳闸(访问故障)的服务，对剩下的进行轮询


    @Bean
    @LoadBalanced //Ribbon 配置负载均衡实现restTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public IRule myRule(){
        return new RandomRule();
    }



}
