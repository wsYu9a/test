package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes2.dex */
public final class al implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c Sb;
    private c TR;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int status;
    }

    public interface b {
        void ox();
    }

    public interface c {
        void oB();
    }

    public al(c cVar) {
        this.TR = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sb = cVar;
        c cVar2 = this.TR;
        if (cVar2 != null) {
            cVar2.oB();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sb = null;
    }

    public final void qY() {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.status = 1;
            this.Sb.a(aVar);
        }
    }
}
