package com.holddie.design.pattern.p2structure.s06adapter.loginadapter.v1.service;


import com.holddie.design.pattern.p2structure.s06adapter.loginadapter.Member;
import com.holddie.design.pattern.p2structure.s06adapter.loginadapter.ResultMsg;

/**
 * Created by Tom.
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
