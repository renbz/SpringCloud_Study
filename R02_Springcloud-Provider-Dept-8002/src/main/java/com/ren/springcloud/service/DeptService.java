package com.ren.springcloud.service;

import com.ren.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author Ren
 */

public interface DeptService {

    public boolean addDept(Dept dept);


    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
