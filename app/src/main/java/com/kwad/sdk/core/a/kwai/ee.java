package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ee implements com.kwad.sdk.core.d<h.a> {
    /* renamed from: a */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("imei");
        aVar.adV = optString;
        if (optString == JSONObject.NULL) {
            aVar.adV = "";
        }
        String optString2 = jSONObject.optString("oaid");
        aVar.adW = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.adW = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.adV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", aVar.adV);
        }
        String str2 = aVar.adW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", aVar.adW);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
