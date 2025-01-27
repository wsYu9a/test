package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GetInviteeNumberParams;

/* loaded from: classes3.dex */
public abstract class x0 extends com.martian.mibook.lib.account.d.n<GetInviteeNumberParams, Integer> {
    public x0(j1 activity) {
        super(activity, GetInviteeNumberParams.class, Integer.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Integer number) {
        if (number == null) {
            return false;
        }
        return super.onPreDataReceived(number);
    }
}
