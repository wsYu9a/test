package com.alipay.sdk.authjs;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ a f5395a;

    /* renamed from: b */
    final /* synthetic */ d f5396b;

    f(d dVar, a aVar) {
        this.f5396b = dVar;
        this.f5395a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", "true");
        } catch (JSONException unused) {
        }
        a aVar = new a(a.f5376c);
        aVar.f5382i = this.f5395a.f5382i;
        aVar.m = jSONObject;
        this.f5396b.f5391a.a(aVar);
    }
}
