package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.ShowWealthParams;
import com.martian.mibook.lib.account.response.ShowWealthResult;

/* loaded from: classes3.dex */
public abstract class j0 extends com.martian.mibook.lib.account.d.n<ShowWealthParams, ShowWealthResult> {
    public j0(j1 activity) {
        super(activity, ShowWealthParams.class, ShowWealthResult.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ShowWealthResult showWealthResult) {
        if (showWealthResult == null) {
            return false;
        }
        return super.onPreDataReceived(showWealthResult);
    }
}
