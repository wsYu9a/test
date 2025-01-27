package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.e;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dr implements com.kwad.sdk.core.d<e.a> {
    /* renamed from: a */
    private static void a2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("target");
        aVar.Sd = optString;
        if (optString == JSONObject.NULL) {
            aVar.Sd = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Sd;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "target", aVar.Sd);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
