package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ad;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cb implements com.kwad.sdk.core.d<ad.a> {
    /* renamed from: a */
    private static void a2(ad.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TA = jSONObject.optBoolean("clickActionButton");
        String optString = jSONObject.optString("adTemplate");
        aVar.TB = optString;
        if (optString == JSONObject.NULL) {
            aVar.TB = "";
        }
        aVar.TC = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.c.a.c cVar = new com.kwad.sdk.core.webview.c.a.c();
        aVar.TD = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b */
    private static JSONObject b2(ad.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.TA;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        String str = aVar.TB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adTemplate", aVar.TB);
        }
        int i2 = aVar.TC;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i2);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.TD);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ad.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ad.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
