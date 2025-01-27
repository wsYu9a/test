package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes2.dex */
public final class h extends v {
    private a UF;

    public interface a {
        void a(h hVar);
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int UG;
    }

    public final void a(a aVar) {
        this.UF = aVar;
    }

    public final void aO(boolean z) {
        int i2 = z ? 1 : 2;
        b bVar = new b();
        bVar.UG = i2;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
        a aVar = this.UF;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        this.UF = null;
    }
}
