package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.RequestUnBlackParams;

/* loaded from: classes3.dex */
public abstract class g0 extends com.martian.mibook.lib.account.d.n<RequestUnBlackParams, Boolean> {
    public g0(j1 activity) {
        super(activity, RequestUnBlackParams.class, Boolean.class);
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
