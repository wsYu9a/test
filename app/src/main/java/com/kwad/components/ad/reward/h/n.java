package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.a.kwai.v;

/* loaded from: classes.dex */
public final class n extends v {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int status;
    }

    public final void ae(boolean z) {
        a aVar = new a();
        aVar.status = z ? 1 : 0;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerNeoStatusListener";
    }
}
