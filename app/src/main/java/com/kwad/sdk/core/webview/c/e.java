package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String aql;
    private final int result;

    public e(int i10, String str) {
        this.result = i10;
        this.aql = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, i.f29758c, this.result);
        x.putValue(jSONObject, "error_msg", this.aql);
        return jSONObject;
    }
}
