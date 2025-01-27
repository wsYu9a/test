package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes3.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private b aaE;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    public interface b {
        void qz();
    }

    public au(b bVar) {
        this.aaE = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
        b bVar = this.aaE;
        if (bVar != null) {
            bVar.qz();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }

    public final void tt() {
        if (this.YI != null) {
            a aVar = new a();
            aVar.status = 1;
            this.YI.a(aVar);
        }
    }
}
