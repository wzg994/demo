package com.wzg.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class Department {

    private Integer id;
    private String departmentName;

//    public Department(Integer id, String departmentName) {
//        this.id = id;
//        this.departmentName = departmentName;
//    }
}
