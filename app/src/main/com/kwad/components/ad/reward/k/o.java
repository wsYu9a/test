package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.tachikoma.a.w;

/* loaded from: classes2.dex */
public final class o extends w implements ar.b {

    /* renamed from: qh */
    @Nullable
    private com.kwad.components.core.playable.a f11722qh;

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.f11691qh;
        this.f11722qh = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ar.b
    public final void a(ar.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.f11722qh;
        if (aVar != null) {
            aVar.b(this);
            this.f11722qh = null;
        }
    }
}
