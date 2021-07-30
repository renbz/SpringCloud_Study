package com.ren.springcloud.service;

import com.ren.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ren
 */
// 服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDeptname("id=>" + id + "没有对应的信息，客户端提供了降级的信息 这个服务现在已经关闭")
                        .setDept_source("没有数据~");
            }

            @Override
            public List<Dept> queryAll() {
                List<Dept> list = new ArrayList();
                list.add(new Dept()
                        .setDeptno(100)
                        .setDeptname("id=>" + 100 + "没有对应的信息，客户端提供了降级的信息 这个服务现在已经关闭")
                        .setDept_source("没有数据~"));
                return list ;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
