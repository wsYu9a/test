package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> Zc;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11955eb;
    private b pZ;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void R(AdTemplate adTemplate);
    }

    public x(List<AdTemplate> list) {
        this.Zc = list;
    }

    private List<AdTemplate> tq() {
        List<AdTemplate> list = this.Zc;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.f11955eb;
        if (bVar != null) {
            return bVar.IB();
        }
        return null;
    }

    public final void a(b bVar) {
        this.pZ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a10 = com.kwad.sdk.core.response.b.e.a(tq(), aVar.creativeId, aVar.adStyle);
            b bVar = this.pZ;
            if (bVar != null) {
                bVar.R(a10);
            }
        } catch (JSONException unused) {
        }
    }

    public x(com.kwad.sdk.core.webview.b bVar) {
        this.f11955eb = bVar;
    }
}
