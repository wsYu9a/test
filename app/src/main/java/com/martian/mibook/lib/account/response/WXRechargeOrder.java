package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class WXRechargeOrder {
    public WXPrepay prepay;
    public MiRechargeOrder rechargeOrder;

    public WXPrepay getPrepay() {
        return this.prepay;
    }

    public MiRechargeOrder getRechargeOrder() {
        return this.rechargeOrder;
    }

    public void setPrepay(WXPrepay prepay) {
        this.prepay = prepay;
    }

    public void setRechargeOrder(MiRechargeOrder rechargeOrder) {
        this.rechargeOrder = rechargeOrder;
    }
}
