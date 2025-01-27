package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private a acX;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.t tVar);
    }

    public final void a(a aVar) {
        this.acX = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acX = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.acX != null) {
            com.kwad.components.core.webview.tachikoma.b.t tVar = new com.kwad.components.core.webview.tachikoma.b.t();
            try {
                try {
                    tVar.parseJson(new JSONObject(str));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            } finally {
                this.acX.b(tVar);
            }
        }
    }
}
