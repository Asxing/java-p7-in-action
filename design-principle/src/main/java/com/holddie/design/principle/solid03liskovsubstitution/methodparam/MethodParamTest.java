package com.holddie.design.principle.solid03liskovsubstitution.methodparam;

import java.util.HashMap;

/**
 * Created by Tom
 */
public class MethodParamTest {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
