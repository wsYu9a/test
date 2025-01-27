package com.martian.mibook.mvvm.ui.repository;

import com.martian.mibook.lib.account.response.AliRechargeOrder;
import com.martian.mibook.lib.account.response.WXRechargeOrder;
import com.martian.mibook.mvvm.base.BaseRepository;
import java.util.Map;
import kotlin.coroutines.Continuation;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class WebViewRepository extends BaseRepository {
    @l
    public final Object f(@k Map<String, String> map, @k Continuation<? super AliRechargeOrder> continuation) {
        return c(new WebViewRepository$createAliPrepayTask$2(this, map, null), continuation);
    }

    @l
    public final Object g(@k Map<String, String> map, @k Continuation<? super WXRechargeOrder> continuation) {
        return c(new WebViewRepository$createWxPrepayTask$2(this, map, null), continuation);
    }
}
