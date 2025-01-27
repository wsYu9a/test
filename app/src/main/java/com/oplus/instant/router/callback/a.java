package com.oplus.instant.router.callback;

import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.h.d;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class a extends Callback {

    /* renamed from: a */
    private Callback f16053a;

    public void a(Callback callback) {
        if (callback == null) {
            callback = new b();
        }
        this.f16053a = callback;
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap hashMap = new HashMap();
            hashMap.put("failMsg", response.getMsg());
            com.oplus.instant.router.g.a.a().c().onStat(hashMap);
        }
        d.e("router_response", response.toString());
        Callback callback = this.f16053a;
        if (callback != null) {
            callback.onResponse(response);
            this.f16053a = null;
        }
    }
}
