package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.HasInviterParams;

/* loaded from: classes3.dex */
public abstract class w extends com.martian.mibook.lib.account.d.n<HasInviterParams, Boolean> {
    public w(j1 activity) {
        super(activity, HasInviterParams.class, Boolean.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Boolean hasInviter) {
        if (hasInviter == null) {
            return false;
        }
        return super.onPreDataReceived(hasInviter);
    }
}
