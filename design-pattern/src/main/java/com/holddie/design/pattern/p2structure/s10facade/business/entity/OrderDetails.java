package com.holddie.design.pattern.p2structure.s10facade.business.entity;

import lombok.Data;

import java.util.Random;

/**
 * 订单详情
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 10:07
 */
@Data
public class OrderDetails {
    // region 私有成员
    private int productNo;
    private String productName;
    private String productDescription;
    private float price;
    private float discountPercent;
    private String addressLine1;
    private String addressLine2;
    private int pinCode;
    private String cardNo;
    // endregion

    public OrderDetails(String productName, String prodDescription, float price,
                        float discount, String addressLine1, String addressLine2,
                        int pinCode, String cardNo) {
        this.productNo = new Random(1).nextInt(100);
        this.productName = productName;
        this.productDescription = prodDescription;
        this.price = price;
        this.discountPercent = discount;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.cardNo = cardNo;
    }
}
