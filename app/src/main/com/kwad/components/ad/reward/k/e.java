package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a yH;

    public interface a {
        void jr();
    }

    public final void a(a aVar) {
        this.yH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.yH = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.yH;
        if (aVar != null) {
            aVar.jr();
        }
    }
}
