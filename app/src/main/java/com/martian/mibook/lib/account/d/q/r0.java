package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.WithdrawAlipayMissionMoneyParams;

/* loaded from: classes3.dex */
public abstract class r0 extends com.martian.mibook.lib.account.d.n<WithdrawAlipayMissionMoneyParams, Integer> {
    public r0(j1 activity) {
        super(activity, WithdrawAlipayMissionMoneyParams.class, Integer.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Integer money) {
        if (money == null) {
            return false;
        }
        return super.onPreDataReceived(money);
    }
}
