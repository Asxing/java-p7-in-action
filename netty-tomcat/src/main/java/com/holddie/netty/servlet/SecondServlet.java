package com.holddie.netty.servlet;

import com.holddie.netty.http.GPRequest;
import com.holddie.netty.http.GPResponse;
import com.holddie.netty.http.GPServlet;

public class SecondServlet extends GPServlet {

    public void doGet(GPRequest request, GPResponse response) throws Exception {
        this.doPost(request, response);
    }

    public void doPost(GPRequest request, GPResponse response) throws Exception {
        response.write("This is Second Serlvet");
    }
}
