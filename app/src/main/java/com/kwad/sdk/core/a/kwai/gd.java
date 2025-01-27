package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ai;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gd implements com.kwad.sdk.core.d<ai.a> {
    /* renamed from: a */
    private static void a2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        String optString = jSONObject.optString("errorMsg");
        aVar.errorMsg = optString;
        if (optString == JSONObject.NULL) {
            aVar.errorMsg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        String str = aVar.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", aVar.errorMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
