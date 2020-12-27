package com.holddie.design.pattern.p2structure.s10facade.facade;


import com.holddie.design.pattern.p2structure.s10facade.business.ICosting;
import com.holddie.design.pattern.p2structure.s10facade.business.IInventory;
import com.holddie.design.pattern.p2structure.s10facade.business.ILogistics;
import com.holddie.design.pattern.p2structure.s10facade.business.IOrderVerify;
import com.holddie.design.pattern.p2structure.s10facade.business.IPaymentGateway;
import com.holddie.design.pattern.p2structure.s10facade.business.entity.OrderDetails;
import com.holddie.design.pattern.p2structure.s10facade.business.impl.CostManager;
import com.holddie.design.pattern.p2structure.s10facade.business.impl.InventoryManager;
import com.holddie.design.pattern.p2structure.s10facade.business.impl.LogisticsManager;
import com.holddie.design.pattern.p2structure.s10facade.business.impl.OrderVerifyManager;
import com.holddie.design.pattern.p2structure.s10facade.business.impl.PaymentGatewayManager;

/**
 * 门面类使用
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 10:08
 */
public class FacadeMain {
    private IInventory inventory = new InventoryManager();
    private IOrderVerify orderVerify = new OrderVerifyManager();
    private ICosting costManager = new CostManager();
    private IPaymentGateway paymentGateway = new PaymentGatewayManager();
    private ILogistics logistics = new LogisticsManager();

    public void finalizeOrder(OrderDetails orderDetails) {
        inventory.update(orderDetails.getProductNo());
        orderVerify.verifyShippingAddress(orderDetails.getPinCode());
        orderDetails.setPrice(
                costManager.applyDiscount(
                        orderDetails.getPrice(),
                        orderDetails.getDiscountPercent()
                )
        );
        paymentGateway.verifyCardDetails(orderDetails.getCardNo());
        paymentGateway.processPayment(orderDetails.getCardNo(), orderDetails.getPrice());
        String shippingAddress = String.format("%s, %s - %d",
                orderDetails.getAddressLine1(),
                orderDetails.getAddressLine2(),
                orderDetails.getPinCode());
        logistics.shipProducts(orderDetails.getCardNo(), shippingAddress);
    }
}
