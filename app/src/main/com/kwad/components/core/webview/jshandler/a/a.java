package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends com.kwad.components.core.webview.jshandler.d {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a.a$a */
    public static class C0449a extends com.kwad.sdk.core.response.a.a {
        public String abm;
    }

    @Override // com.kwad.components.core.webview.jshandler.d
    public final String aL(String str) {
        try {
            C0449a c0449a = new C0449a();
            c0449a.parseJson(new JSONObject(str));
            return c0449a.abm;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.d, com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "checkAppInstalled";
    }
}
