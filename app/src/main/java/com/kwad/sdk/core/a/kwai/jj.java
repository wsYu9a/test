package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jj implements com.kwad.sdk.core.d<WebCloseStatus> {
    /* renamed from: a */
    private static void a2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    /* renamed from: b */
    private static JSONObject b2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = webCloseStatus.interactSuccess;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactSuccess", z);
        }
        int i2 = webCloseStatus.closeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        a2(webCloseStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        return b2(webCloseStatus, jSONObject);
    }
}
