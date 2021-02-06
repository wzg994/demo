package com.wzg.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @author: kb
 * @create: 2020-06-23 10:16
 **/
//@Entity
//@Table(name = "user")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Integer version;
}


