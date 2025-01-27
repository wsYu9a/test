package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.GetHistoryCommissionsParams;
import com.martian.mibook.lib.account.response.TYCommissionList;

/* loaded from: classes3.dex */
public abstract class o extends com.martian.mibook.lib.account.d.n<GetHistoryCommissionsParams, TYCommissionList> {
    public o(j1 activity) {
        super(activity, GetHistoryCommissionsParams.class, TYCommissionList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(TYCommissionList tyCommissionList) {
        if (tyCommissionList == null || tyCommissionList.getCommissionList() == null) {
            return false;
        }
        return super.onPreDataReceived(tyCommissionList);
    }
}
