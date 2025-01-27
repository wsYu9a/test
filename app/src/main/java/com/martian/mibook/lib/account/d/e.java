package com.martian.mibook.lib.account.d;

import com.martian.mibook.lib.account.request.MartianGetWithdrawOrdersRankParams;
import com.martian.mibook.lib.account.response.WithdrawRankList;

/* loaded from: classes3.dex */
public abstract class e extends f<MartianGetWithdrawOrdersRankParams, WithdrawRankList> {
    public e() {
        super(MartianGetWithdrawOrdersRankParams.class, WithdrawRankList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(WithdrawRankList withdrawRankList) {
        if (withdrawRankList == null || withdrawRankList.getWithdrawRanks() == null) {
            return false;
        }
        return super.onPreDataReceived(withdrawRankList);
    }
}
