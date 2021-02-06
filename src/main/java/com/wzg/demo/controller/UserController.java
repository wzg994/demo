package com.wzg.demo.controller;


import com.wzg.demo.dao.UserDao;
import com.wzg.demo.pojo.User;
import com.wzg.demo.util.Result;
import com.wzg.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @description:
 * @author: kb
 * @create: 2020-06-23 10:19
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
//    @Autowired
//    private UserDao userDao;
//    private Logger logger = LoggerFactory.getLogger(UserController.class);

//    @GetMapping("/findAll")
//    public Result<User> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
//        logger.info("查询所有的用户信息");
//        PageRequest pageRequest = PageRequest.of(page - 1, size);
//        Page<User> userPage = userDao.findAll(pageRequest);
//        int a = 2 / 0;
//        logger.info("用户信息:" + userPage.getContent());
//        return ResultUtil.success(userPage);
//    }
//
//    @GetMapping("/findById")
//    public Result<User> findById(Long id) {
//        logger.info("根据id查询用户信息");
//        Optional<User> userOptional = userDao.findById(id);
//        if (userOptional.isPresent()) {
//            logger.info("用户信息:" + userOptional.get());
//            return ResultUtil.success(userOptional.get());
//        } else {
//            return ResultUtil.error(ResultEnum.NOTFOUND);
//        }
//
//    }
}

