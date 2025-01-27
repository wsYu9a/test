package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.ai;

/* loaded from: classes.dex */
public final class o extends v implements ai.b {

    @Nullable
    private com.kwad.components.core.playable.a oP;

    public o(com.kwad.components.ad.reward.j jVar) {
        com.kwad.components.core.playable.a aVar = jVar.oP;
        this.oP = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.oP;
        if (aVar != null) {
            aVar.b(this);
            this.oP = null;
        }
    }
}
