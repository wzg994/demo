package com.wzg.demo.controller;

import com.wzg.demo.util.IDCardUtil;
import com.wzg.demo.util.Result;
import com.wzg.demo.util.ResultUtil;
import com.wzg.demo.util.getTime;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@RestController()
@RequestMapping("/wzg")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/Time")
    public String getTime() throws ParseException {
        String time="";
        SimpleDateFormat timefor= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String times=timefor.format(new Date());
        System.out.println(timefor);
        System.out.println(times);
        time=times;//86400
        String timess="2020-12-31 18:00:00";
        Date date=timefor.parse(timess);
        System.out.println(date);
//        String datatime="2015-09-22 15:16:48";
        SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println("nowtime"+new Date());
        String timesdate = form.format(new Date());
        String timesdatefianlly = form.format(date);//20201231180000
//        String timesdatefianlly = "20201231180000";//20201231180000
        System.out.println("now"+timesdate+",hol"+timesdatefianlly);
//        System.out.println("hol1"+timesdatefianlly1);
        System.out.println("now"+(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate)));
        Double hol=(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate))/864000;
        String  str = String.format("%f",hol);
        double four = Double.parseDouble(str);
        System.out.println(four);

     //   time="The holiday is "+four+"arriver";
        String res = "{";
         res = res +"\"time\":"+four;
         res = res +"}";

        return res;
    }

    @PostMapping("/getWant")
    public Result getWant(HttpServletResponse response,
                          @RequestParam(value = "datetime", required = true) String datetime,
                          // @RequestParam传递的参数格式是param格式
                          // username1和前端传递的参数一致，
                          //String userName,可以和前端不一致
                          @RequestParam(value = "mark", required = true) String mark) throws ParseException {
        System.out.println(response);
        getTime getTime=new getTime();
        String s = getTime.get(datetime, mark);
        Map map=new HashMap();
        map.put("String",s);
        return ResultUtil.success(map);


    }

    @RequestMapping("/getTime")
    public Result getTimes() throws ParseException {
            getTime gettime=new getTime();
        Double aDouble = 123.25;
//        Double aDouble = gettime.get("2021-01-08 18:00:00");
        String s = gettime.get("2021-01-15 18:00:00","周末");
//        String time="";
//        SimpleDateFormat timefor= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String times=timefor.format(new Date());
//        System.out.println(timefor);
//        System.out.println(times);//86400
//        String timess = "2021-01-08 18:00:00";
//        Date date=timefor.parse(timess);
//        System.out.println(date);
////        String datatime="2015-09-22 15:16:48";
//        SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
//        System.out.println("nowtime"+new Date());
//        String timesdate = form.format(new Date());
//        String timesdatefianlly = form.format(date);//20201231180000
//        System.out.println("now"+timesdate+",hol"+timesdatefianlly);
//        System.out.println("now"+(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate)));
//        Double hol=(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate))/864000;
//        String  str = String.format("%.2f",hol);
//        double four = Double.parseDouble(str);
//        System.out.println(four);
//        List list=new ArrayList();
        aDouble=aDouble*100;
        Map map=new HashMap();
        double aa=1212.0/3600;//0.0025  一天86400秒
        System.out.println("aa"+aa);
        System.out.println(3600*24);
        String  str = String.format("%.2f",aa);
        double aaa = Double.parseDouble(str);
//        map.put("time",aDouble);
//        String res = "{";
//        res = res +"距离下班还有"+aDouble;
//        res = res +"小时下班}";
//        String html="<span>"+s+"</span>";
        map.put("time",s);
        map.put("hour",aaa);
        return ResultUtil.success(map);
    }

    @GetMapping("/getNewYear")
    public Result getNewYear() throws ParseException {
        getTime getTime=new getTime();
        String spring = getTime.get("2021-02-12 00:00:00", "春节");
//        response.setContentType("text/html;charset=UTF-8");
        Map map=new HashMap();
        map.put("time",spring);
        return ResultUtil.success(map);

    }

    @GetMapping("/getGoToHome")
    public Result getGoToHome() throws ParseException {
        getTime getTime=new getTime();
        String 下班 = getTime.get("2021-01-11 18:00:00", "下班");
        Map map=new HashMap();
        map.put("time",下班);
        return ResultUtil.success(map);

    }



    @GetMapping("/isId")
    public Result isId(){
        Map map=new HashMap();
        String id="350125199809132459";
        map.put("IDcard",id);
//        IDCardUtil idCardUtil=new IDCardUtil();
        Boolean isid=IDCardUtil.isValid(id);
        String ss="这是一个";
        ss=ss+isid;
        ss=ss+"身份证号码";
        map.put("data",ss);
        System.out.println("是否是身份证"+IDCardUtil.isValid("350125199809132459"));
        return ResultUtil.success(map);
    }
}
