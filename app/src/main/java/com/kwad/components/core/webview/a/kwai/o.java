package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class o extends v {
    private a UK;

    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.UK = aVar;
    }

    public final void b(com.kwad.components.core.webview.a.a.m mVar) {
        super.b((com.kwad.sdk.core.b) mVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "registerMuteStateListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
        if (this.UK != null) {
            com.kwad.components.core.webview.a.a.m mVar = new com.kwad.components.core.webview.a.a.m();
            mVar.Vf = this.UK.isMuted();
            cVar.a(mVar);
        }
    }
}
