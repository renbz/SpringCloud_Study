package com.ren.springcloud.controller;

import com.ren.springcloud.pojo.Dept;
import com.ren.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Ren
 */

@RestController
public class DeptConsumerController {

    //理解： 消费者不应该有service层
    // RestFul  .... 共我们直接调用就可以了！  注册到spring中

    /**
     * 提供多种便捷访问远程http服务的方法，简单的restful服务模板
     * 简单粗暴无脑
     */
    @Autowired
    private RestTemplate restTemplate;

    // Ribbon  这里的地址，应该是一个变量，通过服务名访问，因为通过ribbon负载均衡访问时，不确定访问哪一个服务器
    // private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";



    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }



}