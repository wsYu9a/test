package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.UrlMissionParams;
import com.martian.mibook.lib.account.response.UrlMission;

/* loaded from: classes3.dex */
public abstract class o0 extends com.martian.mibook.lib.account.d.n<UrlMissionParams, UrlMission> {
    public o0(j1 activity) {
        super(activity, UrlMissionParams.class, UrlMission.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(UrlMission urlMission) {
        if (urlMission == null) {
            return false;
        }
        return super.onPreDataReceived(urlMission);
    }
}
