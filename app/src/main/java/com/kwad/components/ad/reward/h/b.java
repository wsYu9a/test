package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class b implements com.kwad.sdk.core.webview.b.a {
    private a wS;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        iT();
    }

    public void iT() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.wS = null;
    }
}
