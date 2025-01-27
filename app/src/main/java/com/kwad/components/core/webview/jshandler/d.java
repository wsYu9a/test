package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.kwad.sdk.core.webview.b.a {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "md5";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.j jVar = new com.kwad.components.core.webview.a.a.j();
        try {
            jVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        a aVar = new a();
        aVar.data = TextUtils.isEmpty(jVar.data) ? "" : com.kwad.sdk.utils.ad.eC(jVar.data);
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
