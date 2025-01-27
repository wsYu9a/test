package com.martian.alipay.dao;

import com.martian.libmars.d.h;
import com.martian.libsupport.j;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class AlipayOrderDao extends j<AlipayOrder> {
    public AlipayOrderDao() {
        super(h.F(), "alipay_orders", 3, AlipayOrder.class);
    }

    public List<AlipayOrder> getUnpayPayment() {
        LinkedList linkedList = new LinkedList();
        if (load(linkedList, 0, 0, "trade_status = ?", new String[]{"0"})) {
            return linkedList;
        }
        return null;
    }

    public boolean insert(String out_trade_no, String fee_value) {
        AlipayOrder alipayOrder = new AlipayOrder();
        alipayOrder.fee_value = fee_value;
        alipayOrder.out_trade_no = out_trade_no;
        alipayOrder.trade_status = 0;
        alipayOrder.createdOn = Long.valueOf(System.currentTimeMillis());
        return insert((AlipayOrderDao) alipayOrder);
    }

    public boolean updatePaymentFail(String out_trade_no) {
        AlipayOrder alipayOrder = new AlipayOrder();
        alipayOrder.out_trade_no = out_trade_no;
        alipayOrder.trade_status = -1;
        return update(alipayOrder);
    }

    public boolean updatePaymentSuccess(String out_trade_no) {
        AlipayOrder alipayOrder = new AlipayOrder();
        alipayOrder.out_trade_no = out_trade_no;
        alipayOrder.trade_status = 1;
        return update(alipayOrder);
    }
}
