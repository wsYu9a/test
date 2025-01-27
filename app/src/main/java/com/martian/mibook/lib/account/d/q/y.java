package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.IntervalBonusParams;
import com.martian.mibook.lib.account.response.IntervalBonus;

/* loaded from: classes3.dex */
public abstract class y extends com.martian.mibook.lib.account.d.n<IntervalBonusParams, IntervalBonus> {
    public y(j1 activity) {
        super(activity, IntervalBonusParams.class, IntervalBonus.class);
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
