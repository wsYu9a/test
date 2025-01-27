package com.martian.mibook.mvvm.ui.repository;

import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.rpauth.response.MartianRPAccount;
import java.util.List;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class AppRepository extends BaseRepository {
    @l
    public final Object f(@k Continuation<? super IntervalBonus> continuation) {
        return c(new AppRepository$acquireIntervalBonus$2(this, null), continuation);
    }

    @l
    public final Object g(@k Continuation<? super CheckinResult> continuation) {
        return c(new AppRepository$checkIn$2(this, null), continuation);
    }

    @l
    public final Object h(@k Continuation<? super BonusPool> continuation) {
        return c(new AppRepository$getBonusPool$2(this, null), continuation);
    }

    @l
    public final Object i(boolean z10, @k Continuation<? super TYInitialBookList> continuation) {
        return c(new AppRepository$getInitialBooks$2(this, z10, null), continuation);
    }

    @l
    public final Object j(@k Continuation<? super MartianRPAccount> continuation) {
        return c(new AppRepository$getMiAccountTask$2(this, null), continuation);
    }

    @l
    public final Object k(@k Continuation<? super MiTaskAccount> continuation) {
        return c(new AppRepository$getMiTaskAccountTask$2(this, null), continuation);
    }

    @l
    public final Object l(int i10, @k Continuation<? super List<? extends TYInitialBook>> continuation) {
        return c(new AppRepository$getPromoteBooks$2(this, i10, null), continuation);
    }

    @l
    public final Object m(int i10, int i11, int i12, @k Continuation<? super List<String>> continuation) {
        return c(new AppRepository$getSearchTips$2(this, i10, i11, i12, null), continuation);
    }

    @l
    public final Object n(@k Continuation<? super ExchangeMoney> continuation) {
        return c(new AppRepository$grabFreshRedPaper$2(this, null), continuation);
    }

    @l
    public final Object o(@k Continuation<? super IntervalBonus> continuation) {
        return c(new AppRepository$intervalBonus$2(this, null), continuation);
    }

    @l
    public final Object p(boolean z10, @k Continuation<? super Boolean> continuation) {
        return c(new AppRepository$updateCheckInNotify$2(this, z10, null), continuation);
    }
}
