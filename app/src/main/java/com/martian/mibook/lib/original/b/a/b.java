package com.martian.mibook.lib.original.b.a;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.d.n;
import com.martian.mibook.lib.original.http.request.ConsumeChaptersParams;
import com.martian.mibook.lib.original.http.response.MiConsumeOrders;

/* loaded from: classes2.dex */
public abstract class b extends n<ConsumeChaptersParams, MiConsumeOrders> {
    public b(j1 activity) {
        super(activity, ConsumeChaptersParams.class, MiConsumeOrders.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MiConsumeOrders miConsumeOrders) {
        if (miConsumeOrders == null) {
            return false;
        }
        return super.onPreDataReceived(miConsumeOrders);
    }
}
