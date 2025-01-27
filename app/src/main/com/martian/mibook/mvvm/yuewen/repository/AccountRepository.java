package com.martian.mibook.mvvm.yuewen.repository;

import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.mibook.mvvm.base.BaseRepository;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class AccountRepository extends BaseRepository {
    public static /* synthetic */ Object h(AccountRepository accountRepository, boolean z10, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return accountRepository.g(z10, continuation);
    }

    @l
    public final Object g(boolean z10, @k Continuation<? super UpgradeInfo> continuation) {
        return c(new AccountRepository$checkUpgrade$2(this, z10, null), continuation);
    }

    @l
    public final Object i(int i10, @k Continuation<? super Unit> continuation) {
        Object c10 = c(new AccountRepository$freeReadWithAd$2(this, i10, null), continuation);
        return c10 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c10 : Unit.INSTANCE;
    }
}
