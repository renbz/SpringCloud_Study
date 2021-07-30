package com.ren.springcloud.dao;

import com.ren.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ren
 */
@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);


    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
