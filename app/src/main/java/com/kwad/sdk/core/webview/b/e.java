package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String ZN;
    private final int result;

    public e(int i2, String str) {
        this.result = i2;
        this.ZN = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "error_msg", this.ZN);
        return jSONObject;
    }
}
