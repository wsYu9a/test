package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ag implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a */
    final /* synthetic */ Object f5500a;

    /* renamed from: b */
    final /* synthetic */ ad f5501b;

    ag(ad adVar, Object obj) {
        this.f5501b = adVar;
        this.f5500a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f5500a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f5501b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
