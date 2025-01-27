package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.CreatAliPrepayParams;
import com.martian.mibook.lib.account.response.AliRechargeOrder;

/* loaded from: classes3.dex */
public abstract class i extends com.martian.mibook.lib.account.d.n<CreatAliPrepayParams, AliRechargeOrder> {
    public i(j1 activity) {
        super(activity, CreatAliPrepayParams.class, AliRechargeOrder.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(AliRechargeOrder aliRechargeOrder) {
        if (aliRechargeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(aliRechargeOrder);
    }
}
