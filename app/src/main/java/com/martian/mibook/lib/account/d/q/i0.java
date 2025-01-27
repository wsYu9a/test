package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.RtParams;
import com.martian.mibook.lib.account.response.Bonus;

/* loaded from: classes3.dex */
public abstract class i0 extends com.martian.mibook.lib.account.d.n<RtParams, Bonus> {
    public i0(j1 activity) {
        super(activity, RtParams.class, Bonus.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Bonus bonus) {
        if (bonus == null) {
            return false;
        }
        return super.onPreDataReceived(bonus);
    }
}
