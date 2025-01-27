package com.kwad.sdk.core.webview.d;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c aJc;

    /* renamed from: com.kwad.sdk.core.webview.d.b$1 */
    public class AnonymousClass1 implements b.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.request.b.a
        public final void a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
            if (b.this.aJc != null) {
                b.this.aJc.a(webCardGetDataResponse);
            }
        }

        @Override // com.kwad.sdk.core.webview.request.b.a
        public final void onError(int i10, String str) {
            if (b.this.aJc != null) {
                b.this.aJc.onError(i10, str);
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String method;
        public String params;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aJc = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.aJc = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e10) {
            c cVar2 = this.aJc;
            if (cVar2 != null) {
                cVar2.onError(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.d.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
                if (b.this.aJc != null) {
                    b.this.aJc.a(webCardGetDataResponse);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void onError(int i10, String str) {
                if (b.this.aJc != null) {
                    b.this.aJc.onError(i10, str);
                }
            }
        });
    }
}
