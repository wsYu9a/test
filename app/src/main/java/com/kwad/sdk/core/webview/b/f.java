package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aqg;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.aqg = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.a(jSONObject, MiConfigSingleton.t0, this.aqg);
        return jSONObject;
    }
}
