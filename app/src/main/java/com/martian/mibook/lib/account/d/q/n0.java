package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.FinishUrlMissionParams;
import com.martian.mibook.lib.account.response.UrlMissionResult;

/* loaded from: classes3.dex */
public abstract class n0 extends com.martian.mibook.lib.account.d.n<FinishUrlMissionParams, UrlMissionResult> {
    public n0(j1 activity) {
        super(activity, FinishUrlMissionParams.class, UrlMissionResult.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(UrlMissionResult urlMissionResult) {
        if (urlMissionResult == null) {
            return false;
        }
        return super.onPreDataReceived(urlMissionResult);
    }
}
