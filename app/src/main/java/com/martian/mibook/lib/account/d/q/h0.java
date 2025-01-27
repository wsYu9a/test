package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.ResetParams;

/* loaded from: classes3.dex */
public abstract class h0 extends com.martian.mibook.lib.account.d.n<ResetParams, Boolean> {
    public h0(j1 activity) {
        super(activity, ResetParams.class, Boolean.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Boolean success) {
        if (success == null) {
            return false;
        }
        return super.onPreDataReceived(success);
    }
}
