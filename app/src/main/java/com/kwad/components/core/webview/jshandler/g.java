package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes3.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private int YJ;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    public g(int i10) {
        this.YJ = i10;
    }

    private void aP(int i10) {
        if (this.YI == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i10;
        this.YI.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
        aP(this.YJ);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }
}
