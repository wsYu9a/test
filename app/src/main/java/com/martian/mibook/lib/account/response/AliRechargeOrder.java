package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class AliRechargeOrder {
    public AliPrepay prepay;
    public MiRechargeOrder rechargeOrder;

    public AliPrepay getPrepay() {
        return this.prepay;
    }

    public MiRechargeOrder getRechargeOrder() {
        return this.rechargeOrder;
    }

    public void setPrepay(AliPrepay prepay) {
        this.prepay = prepay;
    }

    public void setRechargeOrder(MiRechargeOrder rechargeOrder) {
        this.rechargeOrder = rechargeOrder;
    }
}
