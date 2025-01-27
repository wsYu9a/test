package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.MartianGetWithdrawOrdersParams;
import com.martian.mibook.lib.account.response.MartianWithdrawOrderList;

/* loaded from: classes3.dex */
public abstract class c0 extends com.martian.mibook.lib.account.d.n<MartianGetWithdrawOrdersParams, MartianWithdrawOrderList> {
    public c0(j1 activity) {
        super(activity, MartianGetWithdrawOrdersParams.class, MartianWithdrawOrderList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MartianWithdrawOrderList rpWithdrawOrderList) {
        if (rpWithdrawOrderList == null || rpWithdrawOrderList.getWithdrawOrders() == null) {
            return false;
        }
        return super.onPreDataReceived(rpWithdrawOrderList);
    }
}
