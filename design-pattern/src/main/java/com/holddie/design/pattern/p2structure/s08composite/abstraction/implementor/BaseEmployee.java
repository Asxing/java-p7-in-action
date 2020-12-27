package com.holddie.design.pattern.p2structure.s08composite.abstraction.implementor;

import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.IEmployee;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.Subscription;
import lombok.Data;

import java.util.List;

/**
 * 基础员工抽象类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:35
 */
@Data
public abstract class BaseEmployee implements IEmployee {

    protected String name;

    protected int employeeId;

    protected List<Subscription> subscriptions;

}
