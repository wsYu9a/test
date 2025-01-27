package com.martian.mibook.lib.account.d.q;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.GetMiTaskAccountParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;

/* loaded from: classes3.dex */
public abstract class q extends com.martian.mibook.lib.account.d.n<GetMiTaskAccountParams, MiTaskAccount> {
    public q(Activity activity) {
        super(activity, GetMiTaskAccountParams.class, MiTaskAccount.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MiTaskAccount miTaskAccount) {
        if (miTaskAccount == null) {
            return false;
        }
        return super.onPreDataReceived(miTaskAccount);
    }
}
