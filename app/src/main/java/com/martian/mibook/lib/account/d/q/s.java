package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GetTxsCoinsRecordListParams;
import com.martian.mibook.lib.account.response.MiHistoryBookCoinsList;

/* loaded from: classes3.dex */
public abstract class s extends com.martian.mibook.lib.account.d.n<GetTxsCoinsRecordListParams, MiHistoryBookCoinsList> {
    public s(j1 activity) {
        super(activity, GetTxsCoinsRecordListParams.class, MiHistoryBookCoinsList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(MiHistoryBookCoinsList miHistoryBookCoinsList) {
        if (miHistoryBookCoinsList == null) {
            return false;
        }
        return super.onPreDataReceived(miHistoryBookCoinsList);
    }
}
