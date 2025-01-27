package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c YI;

    @Nullable
    private a aaW;

    /* renamed from: eb */
    private final com.kwad.sdk.core.webview.b f11954eb;

    public interface a {
        @MainThread
        void aH(AdTemplate adTemplate);
    }

    public bc(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.f11954eb = bVar;
        this.aaW = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.d.b.b bVar = new com.kwad.sdk.core.webview.d.b.b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (this.aaW != null) {
            if (!TextUtils.isEmpty(bVar.aJi)) {
                bVar.adTemplate.llsid = Long.parseLong(bVar.aJi);
            }
            if (!TextUtils.isEmpty(bVar.extra)) {
                bVar.adTemplate.extra = bVar.extra;
            }
            this.aaW.aH(bVar.adTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSetAdTemplateListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }
}
