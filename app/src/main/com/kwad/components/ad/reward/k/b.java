package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class b implements com.kwad.sdk.core.webview.c.a {
    private a yE;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        js();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    public void js() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.yE = null;
    }
}
