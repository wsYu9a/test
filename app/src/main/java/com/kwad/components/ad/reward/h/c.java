package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class c implements com.kwad.sdk.core.webview.b.a {
    private a wT;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        iT();
    }

    public void iT() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.wT = null;
    }
}
