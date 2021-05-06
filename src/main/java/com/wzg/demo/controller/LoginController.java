package com.wzg.demo.controller;

import com.wzg.demo.util.Result;
import com.wzg.demo.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
//    public String login(){
//        return "od";
//    }
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session) {
        System.out.println("Model" + model);
        Map map=new HashMap();
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("LoginUser",username);
            map.put("data","wzg");
            System.out.println("map"+map);
            return ResultUtil.success(map);
//            return ResultUtil.success("200","登录成功！");
//            map.put("code","200");
        }else{
//            map.put("code","400");
            Model model1 = model.addAttribute("msg", "用户名或者密码错误");

            map.put("data",model1);
            System.out.println("map"+map);
            return ResultUtil.error("400","用户名或者密码错误");
        }


    }
}
