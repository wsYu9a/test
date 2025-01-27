package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes3.dex */
public final class h extends w {
    private a acO;

    public interface a {
        void a(h hVar);
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int acP;
    }

    public final void a(a aVar) {
        this.acO = aVar;
    }

    public final void aW(boolean z10) {
        int i10 = z10 ? 1 : 2;
        b bVar = new b();
        bVar.acP = i10;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.acO = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.acO;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
