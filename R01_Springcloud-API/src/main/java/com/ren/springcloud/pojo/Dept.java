package com.ren.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ren
 */


// 所有的实体来务必实现序列化，否则传输报错
// dept  实体类 orm  列表关系映射
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {

    private long deptno;
    private String deptname;
    // 这个数据存在哪个数据库的字段~  微服务，一个服务对应一个数据库，同一信息可能存在不同的数据库
    private String dept_source;

}
