package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.MartianGetHistoryMoneyParams;
import com.martian.mibook.lib.account.response.HistoryMoneyList;

/* loaded from: classes3.dex */
public abstract class b0 extends com.martian.mibook.lib.account.d.n<MartianGetHistoryMoneyParams, HistoryMoneyList> {
    public b0(j1 activity) {
        super(activity, MartianGetHistoryMoneyParams.class, HistoryMoneyList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(HistoryMoneyList historyMoneyList) {
        if (historyMoneyList == null || historyMoneyList.getHistoryMoneyList() == null) {
            return false;
        }
        return super.onPreDataReceived(historyMoneyList);
    }
}
