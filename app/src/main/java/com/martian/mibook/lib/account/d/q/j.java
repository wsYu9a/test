package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.CreateWxPrepayParams;
import com.martian.mibook.lib.account.response.WXRechargeOrder;

/* loaded from: classes3.dex */
public abstract class j extends com.martian.mibook.lib.account.d.n<CreateWxPrepayParams, WXRechargeOrder> {
    public j(j1 activity) {
        super(activity, CreateWxPrepayParams.class, WXRechargeOrder.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(WXRechargeOrder tyRechargeWeixinOrder) {
        if (tyRechargeWeixinOrder == null) {
            return false;
        }
        return super.onPreDataReceived(tyRechargeWeixinOrder);
    }
}
