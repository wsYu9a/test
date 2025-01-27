package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.MartianGetAllWithdrawOrdersParams;
import com.martian.mibook.lib.account.response.MartianRPWithdrawOrderList;

/* loaded from: classes3.dex */
public abstract class d extends f<MartianGetAllWithdrawOrdersParams, MartianRPWithdrawOrderList> {
    public d() {
        super(MartianGetAllWithdrawOrdersParams.class, MartianRPWithdrawOrderList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(MartianRPWithdrawOrderList rpWithdrawOrderList) {
        if (rpWithdrawOrderList == null || rpWithdrawOrderList.getWithdrawOrders() == null) {
            return false;
        }
        return super.onPreDataReceived(rpWithdrawOrderList);
    }
}
