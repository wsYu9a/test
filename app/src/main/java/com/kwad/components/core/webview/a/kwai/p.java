package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.a.z;

/* loaded from: classes2.dex */
public class p extends v {
    private boolean Ig = true;

    public final void a(z zVar) {
        if (this.Ig) {
            super.b(zVar);
        }
    }

    public final void aP(boolean z) {
        this.Ig = false;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "registerVideoProgressListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
    }
}
