package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryDurationParams;
import com.martian.mibook.lib.account.response.HistoryDurationList;

/* loaded from: classes3.dex */
public abstract class a0 extends com.martian.mibook.lib.account.d.n<MartianGetHistoryDurationParams, HistoryDurationList> {
    public a0(j1 activity) {
        super(activity, MartianGetHistoryDurationParams.class, HistoryDurationList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(HistoryDurationList durationList) {
        if (durationList == null || durationList.getDurationList() == null) {
            return false;
        }
        return super.onPreDataReceived(durationList);
    }
}
