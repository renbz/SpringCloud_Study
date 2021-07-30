package com.ren.springcloud.controller;

/**
 * @author Ren
 */

import com.ren.springcloud.pojo.Dept;
import com.ren.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供restful服务
 */
@RestController
public class DeptController {

    // 获取具体的一些信息 得到看、具体的微服务
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }


    // 注册进来的微服务 ，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:"+services);

        //得到有个具体的微服务
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()

            );
        }
        return this.client;
    }



}
