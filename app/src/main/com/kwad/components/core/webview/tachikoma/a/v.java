package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    private a acZ;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.m mVar);
    }

    public final void a(a aVar) {
        this.acZ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acZ = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.acZ != null) {
            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
            try {
                mVar.parseJson(new JSONObject(str));
                this.acZ.b(mVar);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }
}
