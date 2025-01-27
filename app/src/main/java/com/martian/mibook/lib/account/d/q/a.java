package com.martian.mibook.lib.account.d.q;

import com.martian.mibook.lib.account.request.auth.ActiveParams;

/* loaded from: classes.dex */
public abstract class a extends m0<ActiveParams, Boolean> {
    public a() {
        super(ActiveParams.class, Boolean.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(Boolean success) {
        if (success == null) {
            return false;
        }
        return super.onPreDataReceived(success);
    }
}
