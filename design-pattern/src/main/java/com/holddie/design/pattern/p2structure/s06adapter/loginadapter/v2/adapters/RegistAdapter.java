package com.holddie.design.pattern.p2structure.s06adapter.loginadapter.v2.adapters;

import com.holddie.design.pattern.p2structure.s06adapter.loginadapter.ResultMsg;

/** Created by Tom on 2019/3/16. */
public interface RegistAdapter {
    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
