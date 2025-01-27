package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.a.kwai.v;

/* loaded from: classes.dex */
public final class m extends v {

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerBackPressedListener";
    }

    public final void jc() {
        b(new a());
    }
}
