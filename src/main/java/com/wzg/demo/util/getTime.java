package com.wzg.demo.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class getTime {

    public static String timeStamp2Date(String time) {
        Long timeLong = Long.parseLong(time);
        System.out.println("timeLong"+timeLong);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            System.out.println("date"+date);
            System.out.println("sdf.format(date)"+sdf.format(date));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String get(String time, String name) throws ParseException {
//        String ss=timeStamp2Date(time);
//        System.out.println("时间戳"+ss);
        SimpleDateFormat timefor= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String times=timefor.format(new Date());
//        System.out.println(timefor);
//        System.out.println(times);//86400
//        String timess = "2021-01-08 18:00:00";
        Date date=timefor.parse(time);
        Date dateFinally=new Date();
//        System.out.println("日期"+date);
//        System.out.println("日期"+dateFinally);
//        String datatime="2015-09-22 15:16:48";
//        SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
//        System.out.println("nowtime"+new Date());
//        String timesdate = form.format(new Date());
//        String timesdatefianlly = form.format(date);//20201231180000
//        System.out.println("now"+timesdate+",hol"+timesdatefianlly);
//        System.out.println("now"+dateFinally.getTime()+",hol"+date.getTime());
//        long daytime=date.getTime()-dateFinally.getTime();
        long diff=date.getTime()-dateFinally.getTime();

        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        long sceonds = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000* 60 ))/(1000);

        System.out.println(""+days+"天"+hours+"小时"+minutes+"分"+sceonds+"秒");
        String ssss="距离"+name+"还有"+days+"天"+hours+"小时"+minutes+"分"+sceonds+"秒";

//        daytime = daytime / (1000 * 60 * 60 * 24);
//        System.out.println("datatime2"+daytime);
//        System.out.println("now"+(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate)));
//        Double hol=(Double.valueOf(timesdatefianlly)-Double.valueOf(timesdate))/3600;//天数 *8/3600
//        System.out.println("剩余时间"+hol);
//        System.out.println("剩余时间"+hol*8);
//        System.out.println("剩余时间"+hol*8/3600);
//        String  str = String.format("%.4f",hol);
//        double four = Double.parseDouble(str);
//        System.out.println(four);
        return ssss;
    }
}
