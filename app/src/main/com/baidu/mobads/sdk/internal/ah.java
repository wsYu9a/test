package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a */
    final /* synthetic */ Object f6715a;

    /* renamed from: b */
    final /* synthetic */ ae f6716b;

    public ah(ae aeVar, Object obj) {
        this.f6716b = aeVar;
        this.f6715a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f6715a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f6716b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
