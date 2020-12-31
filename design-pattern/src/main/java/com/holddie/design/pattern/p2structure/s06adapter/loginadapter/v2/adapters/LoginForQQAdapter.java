package com.holddie.design.pattern.p2structure.s06adapter.loginadapter.v2.adapters;

import com.holddie.design.pattern.p2structure.s06adapter.loginadapter.ResultMsg;

/** Created by Tom on 2019/3/16. */
public class LoginForQQAdapter implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
