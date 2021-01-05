package com.holddie.design.pattern.p2structure.s06adapter.loginadapter.v2;

/** Created by Tom. */
public class PassportTest {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

        passportForThird.loginForQQ("");
    }
}
