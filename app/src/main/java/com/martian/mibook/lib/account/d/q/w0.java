package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.WithdrawWeixinParams;
import com.martian.mibook.lib.account.response.MartianRPWithdrawOrder;

/* loaded from: classes3.dex */
public abstract class w0 extends com.martian.mibook.lib.account.d.n<WithdrawWeixinParams, MartianRPWithdrawOrder> {
    public w0(j1 activity) {
        super(activity, WithdrawWeixinParams.class, MartianRPWithdrawOrder.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MartianRPWithdrawOrder withdrawOrder) {
        if (withdrawOrder == null) {
            return false;
        }
        return super.onPreDataReceived(withdrawOrder);
    }
}
