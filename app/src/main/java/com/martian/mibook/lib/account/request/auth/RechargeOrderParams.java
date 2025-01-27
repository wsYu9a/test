package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class RechargeOrderParams extends TYAuthParams {

    @a
    private Integer roid;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "recharge_order.do";
    }

    public Integer getRoid() {
        return this.roid;
    }

    public void setRoid(Integer num) {
        this.roid = num;
    }
}
