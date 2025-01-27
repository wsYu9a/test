package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.StartUrlMissionParams;

/* loaded from: classes3.dex */
public abstract class k0 extends com.martian.mibook.lib.account.d.n<StartUrlMissionParams, Integer> {
    public k0(j1 activity) {
        super(activity, StartUrlMissionParams.class, Integer.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(Integer duration) {
        if (duration == null) {
            return false;
        }
        return super.onPreDataReceived(duration);
    }
}
