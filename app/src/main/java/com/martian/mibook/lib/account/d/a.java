package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.ActivitiesParams;
import com.martian.mibook.lib.account.response.TYActivityList;

/* loaded from: classes3.dex */
public abstract class a extends f<ActivitiesParams, TYActivityList> {
    public a() {
        super(ActivitiesParams.class, TYActivityList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYActivityList tyActivityList) {
        if (tyActivityList == null || tyActivityList.getActivityList() == null) {
            return false;
        }
        return super.onPreDataReceived(tyActivityList);
    }
}
