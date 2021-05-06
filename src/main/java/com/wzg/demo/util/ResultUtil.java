package com.wzg.demo.util;

import com.wzg.demo.exception.UserException;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        System.out.println(object);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getCode());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result success(String code,String msg) {
        Result result=new Result(code,msg);
        return result;
    }

    public static Result error(String code,String msg){
        Result result=new Result(code,msg);
        return result;
    }

    public static Result error(String code,String msg,Object object){
        Result result=new Result(code,msg,object);
        return result;
    }

    public static Result error(ResultEnum resultEnum,Object object){
        return error(resultEnum.getCode(),resultEnum.getMsg(),object);
    }

    public static Result error(UserException userException){
        return error(userException.getCode(),userException.getMessage());
    }
}
