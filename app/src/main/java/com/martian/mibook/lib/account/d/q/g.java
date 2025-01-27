package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.CheckAlipayMissionUserParams;

/* loaded from: classes3.dex */
public abstract class g extends com.martian.mibook.lib.account.d.n<CheckAlipayMissionUserParams, Integer> {
    public g(j1 activity) {
        super(activity, CheckAlipayMissionUserParams.class, Integer.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Integer type) {
        if (type == null) {
            return false;
        }
        return super.onPreDataReceived(type);
    }
}
