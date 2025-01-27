package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWSearchRankParams;
import com.martian.mibook.lib.yuewen.response.TYSearchRankList;

/* loaded from: classes4.dex */
public abstract class o extends com.martian.mibook.lib.account.d.f<YWSearchRankParams, TYSearchRankList> {
    public o() {
        super(YWSearchRankParams.class, TYSearchRankList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYSearchRankList tySearchRankList) {
        if (tySearchRankList == null || tySearchRankList.getSearchRanks() == null) {
            return false;
        }
        return super.onPreDataReceived(tySearchRankList);
    }
}
