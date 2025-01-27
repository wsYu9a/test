package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.TYBonus;
import com.martian.mibook.lib.account.response.WithdrawRankList;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class MissionCenterRepository extends BaseRepository {
    @l
    public final Object f(@l Integer num, @l Integer num2, @k Continuation<? super ExchangeMoney> continuation) {
        return c(new MissionCenterRepository$exchangeDuration$2(this, num, num2, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super WithdrawRankList> continuation) {
        return c(new MissionCenterRepository$getWithdrawOrdersRank$2(this, map, null), continuation);
    }

    @l
    public final Object h(@k Continuation<? super TYBonus> continuation) {
        return c(new MissionCenterRepository$startFiveStar$2(this, null), continuation);
    }
}
