package com.oplus.quickgame.sdk.engine.callback;

import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.i;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class a extends Callback {

    /* renamed from: a */
    private Callback f16205a;

    public void a(Callback callback) {
        if (callback == null) {
            callback = new b();
        }
        this.f16205a = callback;
    }

    @Override // com.oplus.quickgame.sdk.engine.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap hashMap = new HashMap();
            hashMap.put("failMsg", response.getMsg());
            com.oplus.quickgame.sdk.engine.d.a.b().a().onStat(hashMap);
        }
        i.c("router_response", response.toString());
        Callback callback = this.f16205a;
        if (callback != null) {
            callback.onResponse(response);
            this.f16205a = null;
        }
    }
}
