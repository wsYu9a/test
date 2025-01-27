package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.CheckinParams;
import com.martian.mibook.lib.account.response.CheckinResult;

/* loaded from: classes3.dex */
public abstract class h extends com.martian.mibook.lib.account.d.n<CheckinParams, CheckinResult> {
    public h(j1 activity) {
        super(activity, CheckinParams.class, CheckinResult.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(CheckinResult checkinResult) {
        if (checkinResult == null) {
            return false;
        }
        return super.onPreDataReceived(checkinResult);
    }
}
