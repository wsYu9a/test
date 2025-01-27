package com.martian.mibook.lib.account.d.q;

import com.martian.mibook.lib.account.request.BonusPollRankParams;
import com.martian.mibook.lib.account.response.BonusPoolRankList;

/* loaded from: classes3.dex */
public abstract class f extends m0<BonusPollRankParams, BonusPoolRankList> {
    public f() {
        super(BonusPollRankParams.class, BonusPoolRankList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(BonusPoolRankList bonusPoolRankList) {
        if (bonusPoolRankList == null || bonusPoolRankList.getBonusPoolRank() == null) {
            return false;
        }
        return super.onPreDataReceived(bonusPoolRankList);
    }
}
