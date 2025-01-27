package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.IntervalBonusAcquireParams;
import com.martian.mibook.lib.account.response.IntervalBonus;

/* loaded from: classes3.dex */
public abstract class x extends com.martian.mibook.lib.account.d.n<IntervalBonusAcquireParams, IntervalBonus> {
    public x(j1 activity) {
        super(activity, IntervalBonusAcquireParams.class, IntervalBonus.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(IntervalBonus intervalBonus) {
        if (intervalBonus == null) {
            return false;
        }
        return super.onPreDataReceived(intervalBonus);
    }
}
