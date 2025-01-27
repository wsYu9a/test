package com.martian.mibook.mvvm.payment.repository;

import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.mvvm.base.BaseRepository;
import com.martian.mibook.mvvm.payment.data.VipInfo;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class VipPayRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super AliRechargeOrder> continuation) {
        return c(new VipPayRepository$createAliPrepayTask$2(this, map, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super WXRechargeOrder> continuation) {
        return c(new VipPayRepository$createWxPrepayOrder$2(this, map, null), continuation);
    }

    @l
    public final Object h(@l Integer num, @k Continuation<? super MiRechargeOrder> continuation) {
        return c(new VipPayRepository$getRechargeOrder$2(this, num, null), continuation);
    }

    @l
    public final Object i(@l String str, @k Continuation<? super VipInfo> continuation) {
        return c(new VipPayRepository$getVipInfo$2(this, str, null), continuation);
    }
}
