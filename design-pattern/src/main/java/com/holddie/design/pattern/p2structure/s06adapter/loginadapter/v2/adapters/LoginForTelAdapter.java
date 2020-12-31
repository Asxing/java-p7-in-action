package com.holddie.design.pattern.p2structure.s06adapter.loginadapter.v2.adapters;


import com.holddie.design.pattern.p2structure.s06adapter.loginadapter.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTelAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
