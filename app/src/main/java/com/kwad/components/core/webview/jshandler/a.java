package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {

    /* renamed from: com.kwad.components.core.webview.jshandler.a$a */
    public static class C0190a extends com.kwad.sdk.core.response.kwai.a {
        public boolean Sa;

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "isInstalled", this.Sa);
            return jSONObject;
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public String packageName;
    }

    private static boolean aJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.kwad.sdk.utils.ak.ah(ServiceProvider.getContext(), str);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "isAppInstalled";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        C0190a c0190a = new C0190a();
        c0190a.Sa = aJ(bVar.packageName);
        cVar.a(c0190a);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
