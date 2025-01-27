package jb;

import com.martian.mibook.lib.account.request.MartianGetWithdrawOrdersRankParams;
import com.martian.mibook.lib.account.response.WithdrawRankList;

/* loaded from: classes3.dex */
public abstract class c extends d<MartianGetWithdrawOrdersRankParams, WithdrawRankList> {
    public c() {
        super(MartianGetWithdrawOrdersRankParams.class, WithdrawRankList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(WithdrawRankList withdrawRankList) {
        if (withdrawRankList == null || withdrawRankList.getWithdrawRanks() == null) {
            return false;
        }
        return super.onPreDataReceived(withdrawRankList);
    }
}
