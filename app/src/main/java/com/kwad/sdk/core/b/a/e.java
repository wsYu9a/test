package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aan = jSONObject.optBoolean("clickActionButton");
        aVar.aap = jSONObject.optInt("area");
        aVar.lz = jSONObject.optInt("itemClickType");
        aVar.aJe = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.aaq = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.MG = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.MU = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.MU)) {
            aVar.MU = "";
        }
        aVar.aJf = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aJg = jSONObject.optBoolean("isCallbackOnly");
        aVar.aJh = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = aVar.aan;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clickActionButton", z10);
        }
        int i10 = aVar.aap;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "area", i10);
        }
        int i11 = aVar.lz;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "itemClickType", i11);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "convertPageType", aVar.aJe);
        com.kwad.sdk.utils.x.a(jSONObject, "logParam", aVar.aaq);
        com.kwad.sdk.utils.x.putValue(jSONObject, "needReport", aVar.MG);
        com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.MU;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "liveItemId", aVar.MU);
        }
        int i12 = aVar.aJf;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sceneType", i12);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z11 = aVar.aJg;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isCallbackOnly", z11);
        }
        boolean z12 = aVar.aJh;
        if (z12) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "disableCallback", z12);
        }
        return jSONObject;
    }
}
