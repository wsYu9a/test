package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class o implements com.kwad.sdk.core.webview.b.a {
    private List<AdTemplate> Ss;
    private com.kwad.sdk.core.webview.b cV;
    private b oI;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void x(AdTemplate adTemplate);
    }

    public o(com.kwad.sdk.core.webview.b bVar) {
        this.cV = bVar;
    }

    public o(List<AdTemplate> list) {
        this.Ss = list;
    }

    private List<AdTemplate> qV() {
        List<AdTemplate> list = this.Ss;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.cV;
        if (bVar != null) {
            return bVar.yT();
        }
        return null;
    }

    public final void a(b bVar) {
        this.oI = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a2 = com.kwad.sdk.core.response.a.d.a(qV(), aVar.creativeId, aVar.adStyle);
            b bVar = this.oI;
            if (bVar != null) {
                bVar.x(a2);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
