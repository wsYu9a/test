package com.martian.mibook.lib.original.b.a;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.d.n;
import com.martian.mibook.lib.original.http.request.ConsumeChapterParams;
import com.martian.mibook.lib.original.http.response.MiConsumeOrder;

/* loaded from: classes2.dex */
public abstract class c extends n<ConsumeChapterParams, MiConsumeOrder> {
    public c(j1 activity) {
        super(activity, ConsumeChapterParams.class, MiConsumeOrder.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MiConsumeOrder miConsumeOrder) {
        if (miConsumeOrder == null) {
            return false;
        }
        return super.onPreDataReceived(miConsumeOrder);
    }
}
