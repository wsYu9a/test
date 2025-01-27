package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class WXRechargeOrder {
    public int money;
    public WXPrepay prepay;
    public MiRechargeOrder rechargeOrder;

    public WXPrepay getPrepay() {
        return this.prepay;
    }

    public MiRechargeOrder getRechargeOrder() {
        return this.rechargeOrder;
    }

    public void setPrepay(WXPrepay wXPrepay) {
        this.prepay = wXPrepay;
    }

    public void setRechargeOrder(MiRechargeOrder miRechargeOrder) {
        this.rechargeOrder = miRechargeOrder;
    }
}
