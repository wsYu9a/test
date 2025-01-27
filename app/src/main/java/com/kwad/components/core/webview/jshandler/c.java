package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes2.dex */
public final class c implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private int mO;
    private int mP;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    public c(int i2, int i3) {
        this.mO = i2;
        this.mP = i3;
    }

    private void o(int i2, int i3) {
        if (this.Sb == null) {
            return;
        }
        a aVar = new a();
        aVar.showLiveStatus = i2;
        aVar.showLiveStyle = i3;
        this.Sb.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getLiveInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        o(this.mO, this.mP);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
