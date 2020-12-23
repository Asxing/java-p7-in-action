package com.holddie.netty.provider;

import com.holddie.netty.api.IRpcHelloService;

public class RpcHelloServiceImpl implements IRpcHelloService {

    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
