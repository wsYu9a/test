package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.e;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ja implements com.kwad.sdk.core.d<e.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.abr = jSONObject.optString("base64String");
        if (JSONObject.NULL.toString().equals(aVar.abr)) {
            aVar.abr = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.abr;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "base64String", aVar.abr);
        }
        return jSONObject;
    }
}
