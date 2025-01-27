package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aIX;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.aIX = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, i.f29758c, this.result);
        x.a(jSONObject, h3.e.f26408m, this.aIX);
        return jSONObject;
    }
}
