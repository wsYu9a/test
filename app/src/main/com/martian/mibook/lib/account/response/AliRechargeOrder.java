package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class AliRechargeOrder {
    public int money;
    public AliPrepay prepay;
    public MiRechargeOrder rechargeOrder;

    public AliPrepay getPrepay() {
        return this.prepay;
    }

    public MiRechargeOrder getRechargeOrder() {
        return this.rechargeOrder;
    }

    public void setPrepay(AliPrepay aliPrepay) {
        this.prepay = aliPrepay;
    }

    public void setRechargeOrder(MiRechargeOrder miRechargeOrder) {
        this.rechargeOrder = miRechargeOrder;
    }
}
