package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f implements com.kwad.sdk.core.webview.b.a {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean wW;
    }

    public void Z(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        boolean z;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            z = aVar.wW;
        } catch (Exception unused) {
            z = false;
        }
        Z(z);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
