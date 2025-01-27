package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes2.dex */
public final class aj implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private a TN = new a();

    @KsJson
    public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    private void p(int i2, int i3) {
        com.kwad.sdk.core.webview.b.c cVar = this.Sb;
        if (cVar != null) {
            a aVar = this.TN;
            aVar.id = i2;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    public final void aP(int i2) {
        p(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }
}
