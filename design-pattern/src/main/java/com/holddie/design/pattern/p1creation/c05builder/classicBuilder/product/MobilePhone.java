package com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product;

import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.BatteryType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.OperationSystemType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.ScreenType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.StylusType;
import lombok.Data;

/**
 * 手机
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 10:22
 */
@Data
public class MobilePhone {

    private String phoneName;

    private ScreenType phoneScreenType;

    private BatteryType phoneBattery;

    private OperationSystemType operationSystemType;

    private StylusType stylusType;

    public MobilePhone(String s) {
        this.phoneName = s;
    }
}
