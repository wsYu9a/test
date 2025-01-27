package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private i Sc;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String Sd;

        public final String getTarget() {
            return this.Sd;
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int JE;
        public int Se;
        public int Sf;
        public int Sg;
    }

    public e(i iVar) {
        this.Sc = iVar;
    }

    public final void a(com.kwad.sdk.core.response.kwai.a aVar) {
        com.kwad.sdk.core.webview.b.c cVar = this.Sb;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    public final void aO(int i2) {
        b bVar = new b();
        bVar.JE = i2;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.Se = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    public final void h(boolean z, boolean z2) {
        b bVar = new b();
        bVar.Sf = z ? 1 : 0;
        bVar.Sg = z2 ? 1 : 0;
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            i iVar = this.Sc;
            if (iVar != null) {
                iVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
