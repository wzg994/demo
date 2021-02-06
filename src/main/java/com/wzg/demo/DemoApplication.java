package com.wzg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication： 标注这个类是一个springboot的应用； 启动类下的所有资源被导入
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {
    //将springboot应用启动
    //SpringbootApplication类
    //run方法
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
