package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class i implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private o YK;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String YL;

        public final String getTarget() {
            return this.YL;
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int Og;
        public int YM;
        public int YN;
    }

    public i(o oVar) {
        this.YK = oVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            o oVar = this.YK;
            if (oVar != null) {
                oVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    public final void aP(int i10) {
        b bVar = new b();
        bVar.Og = i10;
        a(bVar);
    }

    public final void aU(boolean z10) {
        b bVar = new b();
        bVar.YN = z10 ? 1 : 0;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.YM = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.YI;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }
}
