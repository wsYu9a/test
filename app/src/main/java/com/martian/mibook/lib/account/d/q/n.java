package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GetConsumeOrderListParams;
import com.martian.mibook.lib.account.response.TYConsumeOrderList;

/* loaded from: classes3.dex */
public abstract class n extends com.martian.mibook.lib.account.d.n<GetConsumeOrderListParams, TYConsumeOrderList> {
    public n(j1 activity) {
        super(activity, GetConsumeOrderListParams.class, TYConsumeOrderList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(TYConsumeOrderList miConsumeOrderList) {
        if (miConsumeOrderList == null || miConsumeOrderList.getConsumeOrders() == null) {
            return false;
        }
        return super.onPreDataReceived(miConsumeOrderList);
    }
}
